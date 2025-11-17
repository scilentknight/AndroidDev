package com.androiddevkotlin.simpleinterestcalculationexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etPrincipal;
    private EditText etTime;
    private EditText etRate;
    private Button btnCalculate;
    private TextView tvResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Events Registration
        etPrincipal = findViewById(R.id.etPrincipal);
        etTime = findViewById(R.id.etTime);
        etRate = findViewById(R.id.etRate);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Event Listener/Handler
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Event Response/Processing
                float P = Float.parseFloat(etPrincipal.getText().toString());
                float T = Float.parseFloat(etTime.getText().toString());
                float R = Float.parseFloat(etRate.getText().toString());
                float SI = (P * T * R) / 100;
                tvResult.setText("Result: " + SI);
            }
        });
    }
}
