package com.example.bmi_calculatorandemi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi_calculator extends AppCompatActivity {

    EditText weight, height;
    TextView resulttext;
    String calculation, BMIresult;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
    }

    public void calculateBMI(View view) {
        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();

        float weightValue = Float.parseFloat(s1);
        float heightValue = Float.parseFloat(s2) / 100;
        float s3 = heightValue;
        float bmi = weightValue / (s3 * s3);

        if(bmi <16){
            BMIresult = "Severely Under weight";
        }

        else if(bmi <18.5){
            BMIresult = "Under weight";
        }
        else if (bmi >= 18.5 && bmi <=24.9){
            BMIresult = "Normal weight";
        }
        else if (bmi >= 25 && bmi <=29.9){
            BMIresult = " Over weight";
        }
        else {
            BMIresult = "Obese";
        }

        calculation = "Result:\n\n" + bmi + "\n" + BMIresult;
        resulttext.setText(calculation);


    }
}