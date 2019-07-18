package com.mum.studentmisclient.studentmis;


import java.sql.Timestamp;
import java.util.UUID;


public class Stuff {
    private String uuid;

    private String firstName;

    private String lastName;

    private String gender;

    private String description;

    private EDegree degree;


    private Faculty faculty;
    private  Position position;


    private Timestamp recordedDate;


    public Stuff(String firstName,String lastName,String description,String gender,EDegree degree,Position position,Faculty faculty){
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.description = description;
        this.degree = degree;
        this.recordedDate = new Timestamp(System.currentTimeMillis());
        this.position = position;
        this.faculty = faculty;
    }

    public Stuff(){}

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EDegree getDegree() {
        return degree;
    }

    public void setDegree(EDegree degree) {
        this.degree = degree;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
