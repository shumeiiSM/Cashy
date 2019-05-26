package com.example.a17010233.cashy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reset extends AppCompatActivity {

    Button btnBack, btnSubmit;

    EditText etNPass, etNCPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnReset);

        etNPass = findViewById(R.id.etPass);
        etNCPass = findViewById(R.id.etCP);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPass = etNPass.getText().toString();
                String newCPass = etNCPass.getText().toString();

                if (newPass.isEmpty()) {
                    Toast.makeText(Reset.this, "Please enter your new Password!", Toast.LENGTH_SHORT).show();
                } else if (newCPass.isEmpty()) {
                    Toast.makeText(Reset.this, "Please confirm your new Password!", Toast.LENGTH_SHORT).show();
                } else if (!newPass.equals(newCPass)) {
                    Toast.makeText(Reset.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), Login.class);
                    startActivity(intent);
                }
            }
        });


    }
}
