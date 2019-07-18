package com.mum.studentmisclient.service;


import com.mum.studentmisclient.financemis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;
import java.net.URI;

@Service
public class FinanceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client2.name}")
    private String uri;

    public Double allStudentFee(){

        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/payment/total", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public Double budgetTotal(){

        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/total", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public Double budgetBalance(){

        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/balance", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public Object[] allFinanceInfo(){
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(uri+"/payment/all",HttpMethod.GET,null,Object[].class);
        return  responseEntity.getBody();
    }

    public Object[] allCostInfo(){
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(uri+"/budget/all",HttpMethod.GET,null,Object[].class);
        return  responseEntity.getBody();
    }

    public double totalSchoolFee(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/payment/student/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalDonations(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/payment/donation/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalOtherFee(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/payment/other/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalSalaries(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/salary/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalBonuses(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/bonus/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalTaxes(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/tax/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public double totalOther(){
        ResponseEntity<Double> responseEntity = restTemplate.exchange(uri+"/budget/other/all", HttpMethod.GET,null,Double.class);
        return  responseEntity.getBody();
    }

    public Object[] studentPayments(String studentId){
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(uri+"/student/pays/"+studentId,HttpMethod.GET,null,Object[].class);
        return  responseEntity.getBody();
    }

    public String postStudentFee(StudentFee studentFee){
        URI uri1 = restTemplate.postForLocation(uri+"/payment/student/"+studentFee.getStudentId(),studentFee);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postDonationFee(Donation donation){
        URI uri1 = restTemplate.postForLocation(uri+"/payment/donation/"+donation.getName(),donation);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postOthers(OtherIncome income){
        URI uri1 = restTemplate.postForLocation(uri+"/payment/other/"+income.getName(),income);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postSalary(Salary salary){
        URI uri1 = restTemplate.postForLocation(uri+"/budget/salary/"+salary.getStaffId(),salary);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postBonus(Bonus bonus){
        URI uri1 = restTemplate.postForLocation(uri+"/budget/bonus",bonus);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postTax(Tax tax){
        URI uri1 = restTemplate.postForLocation(uri+"/budget/tax/"+tax.getTaxType(),tax);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }

    public String postOther(OtherCost otherCost){
        URI uri1 = restTemplate.postForLocation(uri+"/budget/other",otherCost);
        if(uri1 != null){
            return "Success";
        }else{
            return  "Error";
        }
    }



}
