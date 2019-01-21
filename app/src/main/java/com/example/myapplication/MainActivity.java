package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button execCalcBMI; //計算ボタン
    private EditText input_height; //身長の入力
    private EditText input_weight; //体重の入力
    private TextView bmi_result; //BMIの算出結果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        execCalcBMI = findViewById(R.id.button_exec_calc);
        input_height = findViewById(R.id.input_height_view);
        input_weight = findViewById(R.id.input_weight_view);
        bmi_result = findViewById(R.id.text_BMI_view);

        execCalcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input_height_double = Double.valueOf(input_height.getText().toString()); //身長の取得
                double input_weight_double = Double.valueOf(input_weight.getText().toString()); //体重の取得
                double BMI = calcBMI(input_height_double, input_weight_double); //BMIの取得
                String result = String.format("%.1f", BMI);
                bmi_result.setText(result);
            }
        });
    }

    // BMIの計算式
    private double calcBMI(double height, double weight){
        double bmi = 0;
        if(weight > 0 && height > 0) {
            bmi = weight / (height * height) * 10000;
        }
        return bmi;
    }
}