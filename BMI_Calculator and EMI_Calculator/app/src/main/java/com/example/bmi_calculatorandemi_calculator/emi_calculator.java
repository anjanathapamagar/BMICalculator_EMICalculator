package com.example.bmi_calculatorandemi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class emi_calculator extends AppCompatActivity {

    private TextView tvresult;;
    private EditText et_loanamount, et_interestrate, et_monthlypayment;;
    private Button calculateEmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculator);

        tvresult = findViewById(R.id.tvresult);
        et_loanamount = findViewById(R.id.etloanamount);
        et_interestrate =  findViewById(R.id.etinterestrate);
        et_monthlypayment = findViewById(R.id.etmonthlypayment);
        calculateEmi = findViewById(R.id.calculateemi_button);
        calculateEmi.setOnClickListener(calculateEmiOnClickListener);

    }


    private View.OnClickListener calculateEmiOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validate()){
                double p = Double.parseDouble(et_loanamount.getText().toString());
                double i = Double.parseDouble(et_interestrate.getText().toString());
                int pay = Integer.parseInt(et_monthlypayment.getText().toString());
                emi emii = new emi(p, i, pay);
                double Emi = emii.EMICalculate();
                tvresult.setText(String.format("Your monthly installment amount is Rs. %s", new DecimalFormat("#.##").format(Emi)));
            }
        }
    };



    private boolean validate(){
        boolean isValidInput = true;


        String p = et_loanamount.getText().toString().trim();
        String i = et_interestrate.getText().toString().trim();
        String pay = et_monthlypayment.getText().toString().trim();
        if (p.equals("")) {
            et_loanamount.setError("Loan amount can not be left empty");
            et_loanamount.requestFocus();
            isValidInput = false;
        }

        if (i.equals("")) {
            et_interestrate.setError("Interest rate can not be left empty");
            et_interestrate.requestFocus();
            isValidInput = false;
        }

        if (pay.equals("")) {
            et_monthlypayment.setError("Monthly installment can not be left empty");
            et_monthlypayment.requestFocus();
            isValidInput = false;
        }

        return isValidInput;
    }



}