package com.mum.studentmisclient.controller;

import com.mum.studentmisclient.service.Calculation;
import com.mum.studentmisclient.service.StudentMISService;
import com.mum.studentmisclient.studentmis.Course;
import com.mum.studentmisclient.studentmis.Department;
import com.mum.studentmisclient.studentmis.Enorllment;
import com.mum.studentmisclient.studentmis.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class StudentmisController {


    @Autowired
    private StudentMISService studentMISService;

    @Autowired
    private Calculation calculation;

    @GetMapping("/")
    public String home(){
        return  "login";
    }


    @GetMapping("students")
    public String allStudents(Model model){
        List<Student> sts = studentMISService.allStudents();
        List<Department> depts = studentMISService.departments();
        model.addAttribute("students",sts);
        model.addAttribute("departements",depts);
        model.addAttribute("student",new Student());
        return "back-End/students/students";
    }

    @PostMapping("students")
    public String newStudent(Model model, @RequestParam Map<String,String> map){
        Student student = new Student(map.get("fname"),map.get("lname"),map.get("gender"),map.get("desc"),new Date(),new Department(map.get("dep")));
        studentMISService.postStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}")
    public String studentDetails(@PathVariable("studentId") String studentId, Model model){
        model.addAttribute("student", studentMISService.studentDetails(studentId));
        return "back-End/studentDetails";
    }

    @GetMapping("students/{studentId}/courses")
    public  String studentCourses(@PathVariable("studentId") String studentId, Model model){
        Student student= studentMISService.studentDetails(studentId);
        List<Enorllment> courses = studentMISService.studentCourses(studentId);
        List<Course> allCourses = studentMISService.departmentCourses();
        model.addAttribute("student",student);
        model.addAttribute("courses",courses);
        model.addAttribute("allCourses",allCourses);
        model.addAttribute("average",calculation.averageGpa(courses));
        return "back-End/students/studentCourses";
    }

    @PostMapping("enorllments")
    public String enrollCourse(@RequestParam Map<String,String> map){
        Enorllment enorllment = new Enorllment(new Student(map.get("studentId")),new Course(map.get("courseId")),0.0,'N');
        studentMISService.enrollCourse(enorllment);
        return "redirect:/students/"+map.get("studentId")+"/courses";
    }

    @GetMapping("/faculties")
    public String faculties(Model model){
        model.addAttribute("faculties",studentMISService.faculties());
        return "back-End/faculties";
    }

    @GetMapping("faculty/{facutyId}/stuffs")
    public String facultyStuffs(@PathVariable("facultyId") String facultyId,Model model){
        model.addAttribute("stuffs",studentMISService.facultyStuffs(facultyId));
        return "back-End/stuffs";
    }

    @GetMapping("courses")
    public String courses(Model model){
        List<Course> courses = studentMISService.departmentCourses();
        List<Department> departments = studentMISService.departments();
        model.addAttribute("courses",courses);
        model.addAttribute("departments",departments);
        return "back-End/Students/courses";
    }

    @PostMapping("courses")
    public String recordCourse(@RequestParam Map<String,String> map){
        int code = Integer.parseInt(map.get("credits"));
        int weight = Integer.parseInt(map.get("weight"));
        Course course = new Course(map.get("code"),map.get("title"),code,weight,new Department(map.get("department")));
        System.out.print(map.get("department"));
        studentMISService.postCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("courses/{courseId}")
    public String courseDetails(@PathVariable("courseId") String courseId,Model model){
       List<Enorllment> enorllments = studentMISService.courseEnorllments(courseId);
        model.addAttribute("students",enorllments);
        return "back-End/students/courseDetails";
    }


    @GetMapping("schoolStuffs")
    public String teachers(Model model){
        model.addAttribute("teachers",studentMISService.allStuffs());
        model.addAttribute("faculties",studentMISService.faculties());
        model.addAttribute("positions",studentMISService.allPositions());
        return  "back-End/students/teachers";
    }




}
