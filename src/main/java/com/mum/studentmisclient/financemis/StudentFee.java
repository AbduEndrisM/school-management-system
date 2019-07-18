package com.mum.studentmisclient.financemis;



public class StudentFee extends Payment{


    private String studentId;

    private String studentNames;

    private String department;

    private StudentPaymentType studentPaymentType;


    public StudentFee(String studentId,String studentNames, String department, StudentPaymentType studentPaymentType) {
        this.studentId = studentId;
        this.studentNames = studentNames;
        this.department = department;
        this.studentPaymentType = studentPaymentType;
    }

    public StudentFee(){}

    @Override
    public double getAmount() {
        return amount;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentNames) {
        this.studentNames = studentNames;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public StudentPaymentType getStudentPaymentType() {
        return studentPaymentType;
    }

    public void setStudentPaymentType(StudentPaymentType studentPaymentType) {
        this.studentPaymentType = studentPaymentType;
    }
}
