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

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button btnBack, btnLogin;
    EditText etUser, etPass;
    TextView tvForgot, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = findViewById(R.id.btnBack);
        btnLogin = findViewById(R.id.btnLog);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);

        tvForgot = findViewById(R.id.tvForgot);
        tvRegister = findViewById(R.id.tvReg);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Forgot.class);
                startActivity(intent);
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                LoginHelper helper = new LoginHelper(Login.this);
                ArrayList<Account> data = helper.getAllAccount();

                for (int i = 0; i < data.size(); i++) {
                    String dname = data.get(i).getName();
                    String dpass = data.get(i).getPass();

                    if (user.isEmpty()) {
                        etUser.setError("Please enter your username!");
                        //Toast.makeText(Login.this, "Please enter your username!", Toast.LENGTH_SHORT).show();
                    } else if (pass.isEmpty()) {
                        etPass.setError("Please enter your password!");
                        //Toast.makeText(Login.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (user.equals(dname) && pass.equals(dpass)) {
                            //Toast.makeText(Login.this, "Existing Name", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            intent.putExtra("name", user);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
//                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                    intent.putExtra("name", user);
//                    startActivity(intent);
            }
        });

    }
}
