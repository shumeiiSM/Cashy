package com.example.a17010233.cashy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

//        Intent intentReceived = getIntent();
//        String qName = intentReceived.getStringExtra("name");
//        String qText = intentReceived.getStringExtra("text");
//        String qDate = intentReceived.getStringExtra("date");
//        String qAmt = intentReceived.getStringExtra("amt");

        // Retrieve the saved data from the SharedPreferences object
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(OweYou.this);
        String thepaid = prefs.getString("opaid", "no paid");
        String theamount = prefs.getString("oamount", "no amount");
        String theselected = prefs.getString("oselectedName", "no selected");
        String thetext = prefs.getString("otext", "no text");
        String thedate = prefs.getString("odate", "no date");

        if (thepaid != null && theamount != null && theselected != null && thetext != null && thedate != null) {
            mypaid.setText(thepaid);
            myname.setText(theselected);
            mytext.setText(thetext);
            mydate.setText(thedate);
            myamount.setText(theamount);
        } else {
            Toast.makeText(OweYou.this, "No Bill Added", Toast.LENGTH_LONG).show();
        }

    }
}
