package com.example.a17010233.cashy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Forgot extends AppCompatActivity {

    Button btnBack, btnCode, btnSubmit;

    EditText etPhone, etCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = findViewById(R.id.btnBack);
        btnCode = findViewById(R.id.btnCode);
        btnSubmit = findViewById(R.id.btnSubmit);

        etPhone = findViewById(R.id.etPhone);
        etCode = findViewById(R.id.etCode);


        final int random = 0;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = etPhone.getText().toString();

                int count = 0;
                for (int i = 0, len = phone.length(); i < len; i++) {
                    if (Character.isDigit(phone.charAt(i))) {
                        count++;
                    }
                }

                if (count >= 9 ) {
                    Toast.makeText(Forgot.this, "Maximum 8 Digits!", Toast.LENGTH_SHORT).show();
                } else {
                    int min = 20;
                    int max = 80;
                    int random = new Random().nextInt((max - min) + 1) + min;

                    Toast.makeText(Forgot.this, String.valueOf(random), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int code = Integer.parseInt(etCode.getText().toString());

                if (code == random) {
                    Intent intent = new Intent(getBaseContext(), Reset.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Forgot.this, "Invalid Code!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
