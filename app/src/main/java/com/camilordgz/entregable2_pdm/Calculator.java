package com.camilordgz.entregable2_pdm;

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
    String opType;
    RadioGroup op1, op2;
    EditText inp1, inp2;
    RadioButton add, sub, mult, div, sin, cos, tan, expo;
    Button calculate;
    TextView result;
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
        add = (RadioButton) findViewById(R.id.add);
        sub = (RadioButton) findViewById(R.id.sub);
        mult = (RadioButton) findViewById(R.id.mult);
        div = (RadioButton) findViewById(R.id.div);
        sin = (RadioButton) findViewById(R.id.sin);
        cos = (RadioButton) findViewById(R.id.cos);
        tan = (RadioButton) findViewById(R.id.tan);
        expo = (RadioButton) findViewById(R.id.expo);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);

        op1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.add) {
                    inp1.setHint("Number 1");
                    inp1.setFocusable(true);
                    inp2.setHint("Number 2");
                    inp2.setFocusable(true);
                    opType = "add";
                } else  if (checkedId == R.id.sub) {
                    inp1.setHint("Number 1");
                    inp1.setFocusable(true);
                    inp2.setHint("Number 2");
                    inp2.setFocusable(true);
                    opType = "add";
                } else if (checkedId == R.id.mult) {
                    inp1.setHint("Number 1");
                    inp1.setFocusable(true);
                    inp2.setHint("Number 2");
                    inp2.setFocusable(true);
                    opType = "mult";
                } else if (checkedId == R.id.div) {
                    inp1.setHint("Numerator");
                    inp1.setFocusable(true);
                    inp2.setHint("Denominator");
                    inp2.setFocusable(true);
                    opType = "add";
                }
            }
        });

        if (!inp1.getText().toString().isEmpty() && !inp2.getText().toString().isEmpty()) {
            num1 = Double.parseDouble(inp1.getText().toString());
            num2 = Double.parseDouble(inp2.getText().toString());

            switch (opType) {
                case "add":

            }
        }




        switch (opType) {
            case "add":
                result.setText("Sum: " + (num1 + num2));
                break;
            case "sub":
                result.setText("Difference: " + (num1 - num2));
                break;
            case "mult":
                result.setText("Product: " + (num1 * num2));
                break;
            case "div":
                if (num2 == 0) {
                    Toast.makeText(this, "INVALID DENOMINATOR", Toast.LENGTH_SHORT).show();
                } else {
                    result.setText("Quotient: " + (num1 / num2));
                }
                break;
            case "sin":
                num1 = Math.toRadians(num1);
                result.setText("Sine: " + (Math.sin(num1)));
                break;
            case "cos":
                num1 = Math.toRadians(num1);
                result.setText("Sine: " + (Math.cos(num1)));
                break;
            case "tan":
                num1 = Math.toRadians(num1);
                result.setText("Sine: " + (Math.tan(num1)));
                break;
            case "expo":
                result.setText("Sine: " + (Math.pow(num1, num2)));
                break;
        }
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Number 1");
                inp1.setFocusable(true);
                inp2.setHint("Number 2");
                inp2.setFocusable(true);
                opType = "sub";

                calculateFunc(opType);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Number 1");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("Number 2");
                inp2.setFocusableInTouchMode(true);
                opType = "mult";

                calculateFunc(opType);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Numerator");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("Denominator");
                inp2.setFocusableInTouchMode(true);
                opType = "div";

                calculateFunc(opType);
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Angle");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("");
                opType = "sin";

                calculateFunc(opType);
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Angle");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("");
                opType = "cos";

                calculateFunc(opType);
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Angle");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("");
                opType = "tan";

                calculateFunc(opType);
            }
        });

        expo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inp1.setHint("Base");
                inp1.setFocusableInTouchMode(true);
                inp2.setHint("Exponent");
                inp1.setFocusableInTouchMode(true);
                opType = "expo";

                calculateFunc(opType);
            }
        });
    }
}
