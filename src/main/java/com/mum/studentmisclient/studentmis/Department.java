package com.mum.studentmisclient.studentmis;



import java.sql.Timestamp;
import java.util.UUID;


public class Department {



    private String uuid;


    private String name;


    private Faculty faculty;


    private Timestamp recordedDate;




    public Department(String name,Faculty faculty){
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.faculty = faculty;
        this.recordedDate =  new Timestamp(System.currentTimeMillis());
    }

    public Department(String uuid){
        this.uuid = uuid;
    }


    public Department(){}

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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }


}
