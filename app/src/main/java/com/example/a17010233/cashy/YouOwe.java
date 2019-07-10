package com.example.a17010233.cashy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class YouOwe extends AppCompatActivity {

    TextView myname, mytext, mydate, myamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_owe);

        myname = findViewById(R.id.name);
        mytext = findViewById(R.id.text);
        mydate = findViewById(R.id.date);
        myamount = findViewById(R.id.amount);

        Intent intentReceived = getIntent();
        String qName = intentReceived.getStringExtra("name");
        String qText = intentReceived.getStringExtra("text");
        String qDate = intentReceived.getStringExtra("date");
        String qAmt = intentReceived.getStringExtra("amt");

        myname.setText(qName);
        mytext.setText(qText);
        mydate.setText(qDate);
        myamount.setText(qAmt);

    }
}
