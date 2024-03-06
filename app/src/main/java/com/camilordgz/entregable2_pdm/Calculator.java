package com.camilordgz.entregable2_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {

    double num1, num2;
    String opType, result;
    RadioGroup op1;
    EditText inp1, inp2;
    RadioButton sin, cos, area, peri;
    Button calculate;
    TextView topMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inp1 = findViewById(R.id.inp1);
        inp2 = findViewById(R.id.inp2);
        sin = (RadioButton) findViewById(R.id.sin);
        cos = (RadioButton) findViewById(R.id.cos);
        area = (RadioButton) findViewById(R.id.area);
        peri = (RadioButton) findViewById(R.id.peri);
        calculate = findViewById(R.id.calculate);
        topMessage = findViewById(R.id.topMessage);
        op1 = findViewById(R.id.op1);

        topMessage.setText("Welcome to Calculator");

        op1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.sin) {
                    inp1.setHint("Angle");
                    inp1.setFocusable(true);
                    inp2.setHint("");
                    inp2.setFocusable(false);
                    inp2.setText("");
                    opType = "sin";
                } else  if (checkedId == R.id.cos) {
                    inp1.setHint("Angle");
                    inp1.setFocusable(true);
                    inp2.setHint("");
                    inp2.setFocusable(false);
                    inp2.setText("");
                    opType = "cos";
                } else if (checkedId == R.id.area) {
                    inp1.setHint("Side 1");
                    inp1.setFocusable(true);
                    inp2.setHint("Side 2");
                    inp2.setFocusable(true);
                    opType = "area";
                } else if (checkedId == R.id.peri) {
                    inp1.setHint("Side 1");
                    inp1.setFocusable(true);
                    inp2.setHint("Side 2");
                    inp2.setFocusable(true);
                    opType = "peri";
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFunc(opType);
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void calculateFunc(String opType) {
        Intent showResults = new Intent(this, ResultScreen.class);
        if (inp1.getText().toString().isEmpty() == true) {
            num1 = 0;
        } else if (inp2.getText().toString().isEmpty() == true) {
            num2 = 0;
        }
        switch (opType) {
            case "sin":
                num1 = Double.parseDouble(inp1.getText().toString());
                result = "Sine: " + (Math.sin(Math.toRadians(num1)));
                break;
            case "cos":
                num1 = Double.parseDouble(inp1.getText().toString());
                result = "Cosine: " + (Math.cos(Math.toRadians(num1)));
                break;
            case "area":
                num1 = Double.parseDouble(inp1.getText().toString());
                num2 = Double.parseDouble(inp2.getText().toString());
                result = "Area: " + (num1 * num2);
                break;
            case "peri":
                num1 = Double.parseDouble(inp1.getText().toString());
                num2 = Double.parseDouble(inp2.getText().toString());
                result = "Perimeter: " + ((num1 * 2) + (num2 * 2));
                break;
        }
        showResults.putExtra("result",result);
        startActivity(showResults);

    }
}
