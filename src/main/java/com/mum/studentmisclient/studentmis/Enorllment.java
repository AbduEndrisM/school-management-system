package com.mum.studentmisclient.studentmis;


import java.sql.Timestamp;
import java.util.UUID;


public class Enorllment {



    private String uuid;


    private Student student;


    private Course course;

    private double score;

    private char gpaGrade;


    private Timestamp recordedDate;

    public Enorllment() {
    }

    public Enorllment(Student student, Course course, double score, char gpaGrade) {
        this.uuid = UUID.randomUUID().toString();
        this.student = student;
        this.course = course;
        this.score = score;
        this.gpaGrade = gpaGrade;
        this.recordedDate = new Timestamp(System.currentTimeMillis());
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public char getGpaGrade() {
        return gpaGrade;
    }

    public void setGpaGrade(char gpaGrade) {
        this.gpaGrade = gpaGrade;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }


}
