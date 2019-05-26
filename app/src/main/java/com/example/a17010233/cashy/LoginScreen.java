package com.example.a17010233.cashy;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    Button btnG, btnL, btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnG = findViewById(R.id.btnGoogle);
        btnL = findViewById(R.id.btnLogin);
        btnR = findViewById(R.id.btnRegister);

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginScreen.this, "Loading Google Plus(+)", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.googleLink)));
                startActivity(intentCall);
            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
        });


    }



}
