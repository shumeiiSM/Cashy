package com.example.a17010233.cashy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddBill extends AppCompatActivity {

    Button btnDone, btnBack;
    ListView lvCheck;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        btnDone = findViewById(R.id.btndone);
        btnBack = findViewById(R.id.btnBack);
        lvCheck = findViewById(R.id.lvCheck);

        ArrayList<Contact> list = new ArrayList<Contact>();
        list = (ArrayList<Contact>) getIntent().getSerializableExtra("QuestionListExtra");


        aa = new AddBillAdapter(this, R.layout.oweyou, list);
        lvCheck.setAdapter(aa);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new HomeFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.layout, fragment).commit();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lvCheck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = (Contact) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), contact.getName() + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }





}
