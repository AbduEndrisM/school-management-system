package com.mum.studentmisclient.service;


import com.mum.studentmisclient.usermis.Roles;
import com.mum.studentmisclient.usermis.User;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${client3.name}")
    private String uri;


    public String createAccount(User user){
        URI url = restTemplate.postForLocation(uri+"/add",user);
        if(url != null){
            return "Success";
        }else{
            return  "Error, try again later";
        }
    }

    public User findUser(String username){
        ResponseEntity<User> userResponseEntity = restTemplate.exchange(uri+"/user/"+username, HttpMethod.GET,null,User.class);
        return  userResponseEntity.getBody();
    }

    public Roles findRole(Long id){
        ResponseEntity<Roles> responseEntity =  restTemplate.getForEntity(uri+"/role/{roleId}",Roles.class,id);
        return responseEntity.getBody();
    }


}
