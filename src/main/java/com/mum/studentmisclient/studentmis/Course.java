package com.mum.studentmisclient.studentmis;


import java.sql.Timestamp;
import java.util.UUID;


public class Course {


    private String uuid;

    private String code;

    private String title;

    private int credits;

    private int weight;

    private Timestamp recordedDate;


    private  Department dept;


    public Course(){

    }

    public Course(String uuid){
        this.uuid=uuid;
    }


    public Course(String code,String title,int credits,int weight,Department department){
        this.uuid = UUID.randomUUID().toString();
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.weight = weight;
        this.recordedDate = new Timestamp(System.currentTimeMillis());
        this.dept = department;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }



}
