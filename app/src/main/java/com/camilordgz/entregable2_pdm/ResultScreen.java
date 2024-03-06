package com.camilordgz.entregable2_pdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultScreen extends AppCompatActivity {

    TextView resultText;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.result_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultText = findViewById(R.id.resultText);
        goBack = findViewById(R.id.goBack);

        resultText.setText(getIntent().getStringExtra("result"));

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCalculator();
            }
        });
    }

    public void toCalculator() {
        Intent toCalculator = new Intent(this, Calculator.class);
        startActivity(toCalculator);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}