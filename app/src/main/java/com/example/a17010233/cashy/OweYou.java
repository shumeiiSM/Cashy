package com.example.a17010233.cashy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OweYou extends AppCompatActivity {

    TextView mypaid, myname, mytext, mydate, myamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owe_you);

        mypaid = findViewById(R.id.paid);
        myname = findViewById(R.id.name);
        mytext = findViewById(R.id.text);
        mydate = findViewById(R.id.date);
        myamount = findViewById(R.id.amount);

        Intent intentReceived = getIntent();
        String paid = intentReceived.getStringExtra("paid");
        String name = intentReceived.getStringExtra("name");
        String amt = intentReceived.getStringExtra("amt");
        String text = intentReceived.getStringExtra("text");
        String date = intentReceived.getStringExtra("date");

        mypaid.setText(paid);
        myname.setText(name);
        mytext.setText(text);
        mydate.setText(date);
        myamount.setText(amt);
    }
}
