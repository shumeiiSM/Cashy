package com.example.a17010233.cashy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btnBack, btnLogin;

    TextView tvLogin;

    EditText etUser, etPhone, etPass, etCPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = findViewById(R.id.btnBack);
        btnLogin = findViewById(R.id.btnLog);

        tvLogin = findViewById(R.id.tvLog);

        etUser = findViewById(R.id.etUser);
        etPhone = findViewById(R.id.etPhone);
        etPass = findViewById(R.id.etPass);
        etCPass = findViewById(R.id.etCP);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String phone = etPhone.getText().toString();
                String pass = etPass.getText().toString();
                String cpass = etCPass.getText().toString();

                int count = 0;
                for (int i = 0, len = phone.length(); i < len; i++) {
                    if (Character.isDigit(phone.charAt(i))) {
                        count++;
                    }
                }

                if (user.isEmpty()) {
                    etUser.setError("Please enter your username!");
                    //Toast.makeText(Register.this, "Please enter your username!", Toast.LENGTH_SHORT).show();
                } else if(phone.isEmpty()) {
                    etPhone.setError("Please enter your phone!");
                    //Toast.makeText(Register.this, "Please enter your phone!", Toast.LENGTH_SHORT).show();
                } else if(pass.isEmpty()) {
                    etPass.setError("Please enter your password!");
                    //Toast.makeText(Register.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
                } else if(cpass.isEmpty()) {
                    etCPass.setError("Please confirm your password!");
                    //Toast.makeText(Register.this, "Please confirm your password!", Toast.LENGTH_SHORT).show();
                } else if(count >= 9) {
                    etPhone.setError("Maximum 8 Digits!");
                    //Toast.makeText(Register.this, "Maximum 8 Digits!", Toast.LENGTH_SHORT).show();
                } else if(!pass.equals(cpass)) {
                    etCPass.setError("Mismatch Password!");
                    //Toast.makeText(Register.this, "Mismatch Password!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("name", user);
                    startActivity(intent);
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });


    }
}
