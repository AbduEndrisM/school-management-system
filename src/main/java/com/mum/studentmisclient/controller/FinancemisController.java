package com.mum.studentmisclient.controller;


import com.mum.studentmisclient.financemis.*;
import com.mum.studentmisclient.service.Calculation;
import com.mum.studentmisclient.service.FinanceService;
import com.mum.studentmisclient.service.StudentMISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

import java.util.List;

@Controller
public class FinancemisController {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private StudentMISService studentMISService;

    @Autowired
    private Calculation calculation;


    @GetMapping("/financeinformation")
    public  String  allFinanceInfo(Model model){
        Object[] objects=  financeService.allFinanceInfo();
        model.addAttribute("studentFees",(List<StudentFee>) objects[0]);
        model.addAttribute("donations",(List<Donation>) objects[1]);
        model.addAttribute("incomes",(List<OtherIncome>) objects[2]);
        model.addAttribute("totalFees",financeService.allStudentFee());
        model.addAttribute("totalDonations",financeService.totalDonations());
        model.addAttribute("totalOthers",financeService.totalOtherFee());
        model.addAttribute("totalIncome",financeService.allStudentFee());
        model.addAttribute("totalExpenses",financeService.budgetTotal());
        model.addAttribute("netProfit",financeService.budgetBalance());
        model.addAttribute("types",StudentPaymentType.values());
        model.addAttribute("students",studentMISService.allStudents());
        return "back-End/Finance/financeinfo";
    }

    @GetMapping("/expenseInformation")
    public String allExpensesInfo(Model model){

        Object[] costs = financeService.allCostInfo();
        model.addAttribute("salaries",(List<Salary>)costs[0]);
        model.addAttribute("bonuses",(List<Bonus>)costs[1]);
        model.addAttribute("taxes",(List<Tax>)costs[2]);
        model.addAttribute("costs",(List<OtherCost>)costs[3]);
        model.addAttribute("totalSalaries",financeService.totalSalaries());
        model.addAttribute("totalBonuses",financeService.totalBonuses());
        model.addAttribute("totalTaxes",financeService.totalTaxes());
        model.addAttribute("totalOtherCosts",financeService.totalOther());
        model.addAttribute("totalIncome",financeService.allStudentFee());
        model.addAttribute("totalExpenses",financeService.budgetTotal());
        model.addAttribute("netProfit",financeService.budgetBalance());
        model.addAttribute("types",StudentPaymentType.values());
        model.addAttribute("students",studentMISService.allStudents());

        return "back-End/Finance/costexpenses";
    }

    @PostMapping("studentFees")
    public String postStudentFee(@RequestParam Map<String,String> map){
        StudentFee studentFee = new StudentFee();
        studentFee.setStudentId(map.get("studentId").split("#")[0]);
        studentFee.setDepartment("NONE");
        studentFee.setStudentNames(map.get("studentId").split("#")[1]+' '+map.get("studentId").split("#")[2]);
        studentFee.setStudentPaymentType(StudentPaymentType.valueOf(map.get("type")));
        studentFee.setAmount(Double.parseDouble(map.get("amount")));
        studentFee.setDescription(map.get("description"));
        studentFee.setDate(LocalDate.now());
        financeService.postStudentFee(studentFee);
        return "redirect:/financeinformation";
    }

    @PostMapping("donationFees")
    public String postDonationFee(@RequestParam Map<String,String> map){
        Donation donation = new Donation();
        donation.setName(map.get("name"));
        donation.setAddress(map.get("address"));
        donation.setDate(LocalDate.now());
        donation.setAmount(Double.parseDouble(map.get("amount")));
        donation.setDescription(map.get("description"));
        financeService.postDonationFee(donation);
        return  "redirect:/financeinformation";
    }

    @PostMapping("otherIncomeFees")
    public String postOtherIncome(@RequestParam Map<String,String> map){
        OtherIncome income = new OtherIncome();
        income.setName(map.get("name"));
        income.setAddress(map.get("address"));
        income.setDate(LocalDate.now());
        income.setAmount(Double.parseDouble(map.get("amount")));
        income.setDescription(map.get("description"));
        financeService.postOthers(income);
        return  "redirect:/financeinformation";
    }

    @GetMapping("students/{studentId}/payments")
    public String studentPayments(@PathVariable("studentId") String studentId,Model model){
        Object object[] = financeService.studentPayments(studentId);
        model.addAttribute("student",studentMISService.studentDetails(studentId));
        model.addAttribute("total",(Double)object[0]);
        model.addAttribute("payments",object[1]);
        model.addAttribute("remaining",(45000.0 - (Double)object[0]));
        return "back-End/students/studentPayments";

    }
}
