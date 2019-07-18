package com.mum.studentmisclient.studentmis;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class Student {


    private String uuid;

    private String firstName;

    private String lastName;

    private String gender;

    private String description;


    private Date dob;


    private Timestamp recordedDate;


    private Department department;


    public Student(String firstName, String lastName, String gender, String description, Date dob,Department department) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.description = description;
        this.dob = dob;
        this.recordedDate = new Timestamp(System.currentTimeMillis());
        this.department = department;
    }

    public Student(String uuid){
        this.uuid = uuid;
    }

    public Student(){}

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

