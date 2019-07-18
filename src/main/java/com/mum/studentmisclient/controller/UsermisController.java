package com.mum.studentmisclient.controller;


import com.mum.studentmisclient.service.StudentMISService;
import com.mum.studentmisclient.studentmis.Course;
import com.mum.studentmisclient.studentmis.Enorllment;
import com.mum.studentmisclient.studentmis.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Map;

@Controller
public class UsermisController {

    @Autowired
    private StudentMISService studentMISService;

    @GetMapping("access")
    public String login(){
        return "redirect:/students";
    }

    @PostMapping("recordGrade")
    public String recordGrade(@RequestParam Map<String,String> map, Model model){
        Enorllment enorllment = new Enorllment();
        enorllment.setGpaGrade(map.get("gpa").charAt(0));
        enorllment.setScore(Double.parseDouble(map.get("score")));
        enorllment.setCourse(new Course(map.get("courseId")));
        enorllment.setStudent(new Student(map.get("studentId")));
        enorllment.setRecordedDate(new Timestamp(System.currentTimeMillis()));
        enorllment.setUuid(map.get("uuid"));
        studentMISService.enrollCourse(enorllment);
        //model.addAttribute("courseId",map.get("courseId"));
        return "redirect:/courses/"+map.get("courseId");
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }
}
