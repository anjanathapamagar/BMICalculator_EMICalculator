package com.example.bmi_calculatorandemi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btnbmi, btnemi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbmi = findViewById(R.id.btnbmi);
        btnemi = findViewById(R.id.btnemi);

        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbmi_calculator();
            }
        });

        btnemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemi_calculator();
            }
        });

    }

    public void openbmi_calculator(){
        Intent intent = new Intent(this, bmi_calculator.class);
        startActivity(intent);
    }

    public  void openemi_calculator(){
        Intent intent2 = new Intent(this, emi_calculator.class);
        startActivity(intent2);
    }

}