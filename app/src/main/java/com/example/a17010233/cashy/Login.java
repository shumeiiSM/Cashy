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

public class Login extends AppCompatActivity {

    Button btnBack, btnLogin;
    EditText etUser, etPass;
    TextView tvForgot, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

                if (user.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your username!", Toast.LENGTH_SHORT).show();
                } else if(pass.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your password!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("name", user);
                    startActivity(intent);
                }
            }
        });

    }
}