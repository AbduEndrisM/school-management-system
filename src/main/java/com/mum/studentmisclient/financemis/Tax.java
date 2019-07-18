package com.mum.studentmisclient.financemis;




public class Tax extends Budget{


    private String fiscalYear;

    private TaxType taxType;

    @Override
    public double getAmount() {
        return amount;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }
}
