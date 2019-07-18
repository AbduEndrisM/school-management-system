package com.mum.studentmisclient.service;


import com.mum.studentmisclient.financemis.*;
import com.mum.studentmisclient.studentmis.Enorllment;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class Calculation {


    public String averageGpa(List<Enorllment> enorllments){
        int totalCredits = 0;
        double totalGrades = 0.0;
        for(Enorllment enorllment:enorllments){
            if(enorllment.getGpaGrade() != 'N'){
                if(enorllment.getGpaGrade() == 'A'){
                    totalGrades += 4;
                }else if(enorllment.getGpaGrade() == 'B'){
                    totalGrades += 3;
                }else{
                    totalGrades += 2;
                }
                totalCredits += 1;
            }
        }
        totalCredits = totalCredits > 0 ? totalCredits : 1;
        return new DecimalFormat("#.##").format( totalGrades/totalCredits);
    }

    public double totalStudentFee(List<StudentFee> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }


    public double totalDonations(List<Donation> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }

    public double totalOtherIncome(List<OtherIncome> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }

    public double totalSalaries(List<Salary> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }

    public double totalBonueses(List<Bonus> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }

    public double totalTaxes(List<Tax> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }

    public double totalOtherExpenses(List<OtherCost> studentFees){

        return studentFees.stream().mapToDouble(x -> x.getAmount()).sum();
    }



}
