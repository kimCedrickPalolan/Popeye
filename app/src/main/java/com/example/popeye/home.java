package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class home extends AppCompatActivity {
    private static final String TAG = "home";
    Button save, next, back, button;
    EditText etprovince, etmunicipality, etbarangay, ethouseholdhead, etnameofrespondent, ettotalhouseholdmember, etaddress;
    DatabaseHelper db;
    private TextView mDisplayDate,tvdate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DatabaseHelper(home.this);
        etprovince = findViewById(R.id.province);
        etmunicipality = findViewById(R.id.municipality);
        etbarangay = findViewById(R.id.barangay);
        ethouseholdhead = findViewById(R.id.q2);
        etnameofrespondent = findViewById(R.id.respondentname);
        ettotalhouseholdmember = findViewById(R.id.totalmember);
        etaddress = findViewById(R.id.address);
        tvdate2=findViewById(R.id.q5);

        Spinner type = (Spinner) findViewById(R.id.ettype);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(home.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.type));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(myAdapter);

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String province = etprovince.getText().toString();
                String municipality = etmunicipality.getText().toString();
                String barangay = etbarangay.getText().toString();
                String householdhead = ethouseholdhead.getText().toString();
                String nameofrespondent = etnameofrespondent.getText().toString();
                String householdtotal = ettotalhouseholdmember.getText().toString();
                String address = etaddress.getText().toString();;
                String type1 = type.getSelectedItem().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(new Date());

                String updated_at = "";

               if (db.addBooklet( type1,province, municipality, barangay,address,nameofrespondent,householdhead, householdtotal,date,updated_at)){
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent registerIntent = new Intent(home.this, Survey2.class);
                    startActivity(registerIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(home.this, menu.class);
                startActivity(registerIntent);
            }
        });
    }
}








