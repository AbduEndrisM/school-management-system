package com.mum.studentmisclient.controller;


import com.mum.studentmisclient.service.UserService;
import com.mum.studentmisclient.usermis.Roles;
import com.mum.studentmisclient.usermis.User;
import com.mum.studentmisclient.utility.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UsermisRestController {

    @Autowired
    private UserService userService;

    @PostMapping("authentication")
    public String findUserByEmail(@RequestParam Map<String,String> map, HttpSession session){
        User user =  userService.findUser(map.get("username"));
        if(user != null){
            if(user.getPassword().equals(map.get("password"))){
                session.setAttribute("user",user);
                return "Welcome";
            }
            return "Invalid username or password";
        }else{
            return  "Unknown User";
        }
    }

    @PostMapping("createAccount")
    public String createAccount(@RequestParam Map<String,String> map){
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(Md5.getMd5(map.get("password")));
        Roles role = userService.findRole(1L);
        user.setRoles(role);
        userService.createAccount(user);
        return "redirect:/";
    }
}
