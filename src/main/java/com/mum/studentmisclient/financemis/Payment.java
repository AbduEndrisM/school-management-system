package com.mum.studentmisclient.financemis;



import java.time.LocalDate;
import java.util.UUID;


public  abstract   class Payment {


    private String id = UUID.randomUUID().toString();

    protected double amount;

    private LocalDate date;

    private String description;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



