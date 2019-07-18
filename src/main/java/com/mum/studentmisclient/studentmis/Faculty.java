package com.mum.studentmisclient.studentmis;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;



public class Faculty implements Serializable {



    private String uuid = UUID.randomUUID().toString();

    private String name;

    private Timestamp recordedDate;





    public  Faculty(){}


    public Faculty(String name){
        this.name = name;
        uuid = UUID.randomUUID().toString();
        recordedDate = new Timestamp(System.currentTimeMillis());
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

    public Timestamp getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Timestamp recordedDate) {
        this.recordedDate = recordedDate;
    }






}
