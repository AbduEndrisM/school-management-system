package com.mum.studentmisclient.financemis;


import java.time.LocalDate;
import java.util.UUID;


public  abstract class Budget {


    protected String id = UUID.randomUUID().toString();

    protected double amount;

    protected LocalDate date;

    protected String description;

    public Budget(double amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Budget() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
