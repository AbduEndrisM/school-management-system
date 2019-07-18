package com.mum.studentmisclient.financemis;


import java.time.LocalDate;

public class Bonus extends Budget
{

    public Bonus(double amount, LocalDate date, String description) {
        super(amount, date, description);
    }

    public Bonus(){}

    @Override
    public double getAmount() {
        return amount;
    }

}
