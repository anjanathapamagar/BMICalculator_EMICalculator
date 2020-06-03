package com.example.bmi_calculatorandemi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmi_calculator extends AppCompatActivity {

    EditText etweight, etheight;
    TextView resulttext, tvres;
    String calculation, BMIresult;
   Button calculate_button, btnreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);


        etweight = findViewById(R.id.etweight);
        etheight = findViewById(R.id.etheight);
        resulttext = findViewById(R.id.result);
        tvres = findViewById(R.id.tvres);
        btnreset = findViewById(R.id.btnreset);
        calculate_button = findViewById(R.id.calculate_button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sweight = etweight.getText().toString();
                String sheight =etheight.getText().toString();

                if(sweight.equals("")){
                    etweight.setError("Please enter Your weight");
                    etweight.requestFocus();
                    return;
                }
                if (sheight.equals("")){
                    etheight.setError("Please Enter Your Height");
                    etheight.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(sweight);
                float height = Float.parseFloat(sheight)/100;

                float valuofbmi = CalculateBMI(weight,height);

                tvres.setText(interpreteBMI(valuofbmi));
                resulttext.setText("Your BMI is " + valuofbmi);
            }
        });

                btnreset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etheight.setText("");
                        etweight.setText("");
                        tvres.setText("");
                        resulttext.setText("");
                    }
                });
    }


    public float CalculateBMI(float weight, float height){
        return  weight / (height * height);
    }


    public String interpreteBMI(float bmivalue){
        if (bmivalue < 16){
            return "Servely Underweight";
        }
        else if (bmivalue < 18.5){
            return "Under weight";
        }
        else if (bmivalue < 24.9){
            return "Normal weight";
        }
        else if (bmivalue < 29.9){
            return " Over weight";
        }
        else {
            return "Obese";
        }

    }

}