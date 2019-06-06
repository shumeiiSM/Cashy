package com.example.a17010233.cashy;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    Button btnL, btnR;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnL = findViewById(R.id.btnLogin);
        btnR = findViewById(R.id.btnRegister);
        iv = findViewById(R.id.imageLogo);

//        RotateAnimation anim = new RotateAnimation(0f, 360f,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);

//        iv.clearAnimation();
//        RotateAnimation anim = new RotateAnimation(30, 360, iv.getWidth()/2, iv.getHeight()/2);
//        anim.setFillAfter(true);
//        anim.setRepeatCount(0);
//        anim.setDuration(10000);
//        iv.startAnimation(anim);

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
