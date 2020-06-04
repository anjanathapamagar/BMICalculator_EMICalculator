package com.example.bmi_calculatorandemi_calculator;

public class emi {

    private double principle;
    private double interest;
    private int payments;

   public emi(double principle, double interest, int payments){
        this.principle = principle;
        this.interest = interest/(12*100);
        this.payments = payments;
    }


    public double EMICalculate(){
        return  principle * interest * ((Math.pow((1 + interest), payments)) / (Math.pow((1 + interest), payments) - 1));
    }


}
