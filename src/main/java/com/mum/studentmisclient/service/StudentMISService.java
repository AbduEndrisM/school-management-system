package com.mum.studentmisclient.service;


import com.mum.studentmisclient.studentmis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class StudentMISService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${client1.name}")
    private String uri;


    public List<Student> allStudents() {
        ResponseEntity<List<Student>> response = restTemplate
                .exchange(uri + "/students", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Student>>() {
        });
        return response.getBody();
    }


    public List<Stuff> allStuffs(){
        ResponseEntity<List<Stuff>> responseEntity = restTemplate.exchange(uri + "/stuffs", HttpMethod.GET, null, new ParameterizedTypeReference<List<Stuff>>() {
        });
        return  responseEntity.getBody();
    }

    public List<Position> allPositions(){
        ResponseEntity<List<Position>> responseEntity = restTemplate.exchange(uri + "/positions", HttpMethod.GET, null, new ParameterizedTypeReference<List<Position>>() {
        });
        return  responseEntity.getBody();
    }


    public Student studentDetails(String studentId) {
        ResponseEntity<Student> response = restTemplate.getForEntity(uri + "/students/{studentId}", Student.class, studentId);
        return response.getBody();
    }

    public List<Enorllment> studentCourses(String studentId) {
        ResponseEntity<List<Enorllment>> responseEntity = restTemplate
                .exchange(uri + "/students/" + studentId + "/courses", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Enorllment>>() {
        });
        return responseEntity.getBody();
    }



    public List<Faculty> faculties() {
        ResponseEntity<List<Faculty>> responseEntity = restTemplate.exchange(uri + "/faculties", HttpMethod.GET, null, new ParameterizedTypeReference<List<Faculty>>() {
        });
        return responseEntity.getBody();
    }

    public List<Stuff> facultyStuffs(String facultyId) {
        ResponseEntity<List<Stuff>> responseEntity = restTemplate.exchange(uri + "/faculties/" + facultyId + "/stuffs", HttpMethod.GET, null, new ParameterizedTypeReference<List<Stuff>>() {
        });
        return responseEntity.getBody();
    }

    public List<Course> departmentCourses() {
        ResponseEntity<List<Course>> responseEntity = restTemplate.exchange(uri + "/courses", HttpMethod.GET, null, new ParameterizedTypeReference<List<Course>>() {
        });
        return responseEntity.getBody();
    }

    public List<Enorllment> courseEnorllments(String courseId) {
        ResponseEntity<List<Enorllment>> responseEntity = restTemplate.exchange(uri + "/courses/" + courseId + "/students", HttpMethod.GET, null, new ParameterizedTypeReference<List<Enorllment>>() {
        });
        return responseEntity.getBody();
    }

    public List<Department> departments() {
        ResponseEntity<List<Department>> responseEntity = restTemplate.exchange(uri + "/departments", HttpMethod.GET, null, new ParameterizedTypeReference<List<Department>>() {
        });
        System.out.print(responseEntity.getBody().size());
        return responseEntity.getBody();
    }

    public String postStudent(Student student) {
        URI url = restTemplate.postForLocation(uri + "/students", student);
        if (url != null) {
            return "Success";
        } else {
            return "Error, try again later";
        }
    }

    public String postCourse(Course course){
        URI url = restTemplate.postForLocation(uri+"/courses",course);
        if (url != null) {
            return "Success";
        } else {
            return "Error, try again later";
        }
    }

    public String enrollCourse(Enorllment enorllment){
        URI url = restTemplate.postForLocation(uri+"/enorllments",enorllment);
        if(url != null){
            return "Success";
        }else{
            return "Error, try again later";
        }

    }




}
