package com.example.a17010233.cashy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddOweBill extends AppCompatActivity {

    Button btnDone, btnBack;
    ListView lvCheck;

    Button btnDate, btnIcon;
    TextView tvDate;
    EditText etMoney, etText;
    Spinner spinner;

    String paid;
    String selectedName;
    ArrayList<String> name;

    AddBillAdapter billAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owe_bill);

        name = new ArrayList<String>();

        btnDone = findViewById(R.id.btndone);
        btnBack = findViewById(R.id.btnBack);
        lvCheck = findViewById(R.id.lvCheck);

        btnDate = findViewById(R.id.btnDate);
        btnIcon = findViewById(R.id.btnIcon);
        tvDate = findViewById(R.id.tvDate);
        etMoney = findViewById(R.id.etMoney);
        etText = findViewById(R.id.etText);
        spinner = findViewById(R.id.spinner);

        //ArrayList<String> imageslist = (ArrayList<String>) getIntent().getSerializableExtra("QuestionListExtra");
        //list = (ArrayList<Contact>) getIntent().getSerializableExtra("QuestionListExtra");
        // aa = new AddBillAdapter(this, R.layout.oweyou, list);
        // lvCheck.setAdapter(aa);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                    case 1:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                    case 2:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                    case 3:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                    case 4:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                    case 5:
                        paid = String.valueOf(spinner.getSelectedItem());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        String cDate = date.format(new Date());
        tvDate.setText(cDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        tvDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                // Create the DatePicker Dialog
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(AddOweBill.this,
                        myDateListener, mYear, mMonth, mDay);

                myDateDialog.show();
            }
        });


        final List<Friend> users = new ArrayList<>();
        users.add(new Friend("Vanessa", false));
        users.add(new Friend("Shao Jie", false));
        users.add(new Friend("Jerome", false));
        users.add(new Friend("Alvina", false));
        users.add(new Friend("Norman", false));

        final AddBillAdapter adapter = new AddBillAdapter(this, users);
        lvCheck.setAdapter(adapter);

        lvCheck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Friend model = users.get(i);

                if (model.isSelected()) {
                    model.setSelected(false);
                    name.add(model.getName());

                } else {
                    model.setSelected(true);
                    if (name.size() != 0) {
                        name.remove(name.size() - 1);
                    }
                }
                users.set(i, model);

                //now update adapter
                adapter.updateRecords(users);
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = etMoney.getText().toString();
                String text = etText.getText().toString();
                String date = tvDate.getText().toString();

                for(int i = 0; i<name.size(); i++){
                    selectedName += name.get(i);
                }

                Intent intent = new Intent(getBaseContext(),OweYou.class);
                intent.putExtra("name",paid);
                intent.putExtra("name",selectedName);
                intent.putExtra("amt",amount);
                intent.putExtra("text",text);
                intent.putExtra("date",date);
                startActivity(intent);

                //Toast.makeText(AddBill.this, (CharSequence) name, Toast.LENGTH_LONG).show();
                //finish();

//                for (int i = 0; i < users.size(); i++) {
//                    Friend friend = users.get(i);
//
//                    if (friend.isSelected()) {
//                        selectedName = friend.getName();
//                    }
//                }
            }
            //Toast.makeText(AddBill.this, paid + " paid $" + amount + "\n" , Toast.LENGTH_LONG).show();


//                Fragment fragment = new HomeFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.layout, fragment).commit();
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
