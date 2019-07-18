package com.mum.studentmisclient.financemis;


import java.time.LocalDate;



public class Salary extends Budget {

    private String staffId;
    private String department;
    private String staffNames;

    public Salary(String staffId,String staffNames, String department, double amount, LocalDate date, String description) {
        this.staffId = staffId;
        this.staffNames = staffNames;
        this.department = department;
        this.amount=amount;
        this.date=date;
        this.description=description;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
