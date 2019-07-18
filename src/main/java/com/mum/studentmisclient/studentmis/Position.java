package com.mum.studentmisclient.studentmis;


import java.sql.Timestamp;
import java.util.UUID;


public class Position {


    private String uuid;

    private String name;

    private double salary;

    private Timestamp recordedDate;


    private Stuff stuff;





    public Position(){}


    public Position(String name,double salary){
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
        this.recordedDate = new Timestamp(System.currentTimeMillis());
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }


}
