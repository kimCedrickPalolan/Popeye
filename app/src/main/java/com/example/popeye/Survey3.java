package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Survey3 extends AppCompatActivity  {

    EditText etq15,etq18,etpersonel;
    Button btnsave,btnNext;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey3);

        db = new DatabaseHelper(Survey3.this);
        etq15 = (EditText)findViewById(R.id.q15);
        etq18 = (EditText)findViewById(R.id.q18);
        etpersonel = (EditText)findViewById(R.id.personel2);



//      #spinner of question 16
        Spinner sourceOfIncome = (Spinner) findViewById(R.id.q16);
        ArrayAdapter<String> SOI = new ArrayAdapter<String>(Survey3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sourceOfIncome));
        SOI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceOfIncome.setAdapter(SOI);

//      #spinner of question 17
        Spinner statusOfWork = (Spinner) findViewById(R.id.q17);
        ArrayAdapter<String> SOW = new ArrayAdapter<String>(Survey3.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.statusOfWork));
        SOW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusOfWork.setAdapter(SOW);

        btnsave = (Button)findViewById(R.id.btnsave1);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q15 = etq15.getText().toString();
                String q16 = sourceOfIncome.getSelectedItem().toString();
                String q17 = statusOfWork.getSelectedItem().toString();
                String q18 = etq18.getText().toString();
                String personel = etpersonel.getText().toString();
                String updated_at = "";
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());

                if (db.addeconomic(q15,q16,q17,q18,created_at,updated_at,personel)) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Survey3.this, Survey4.class);
                startActivity(registerIntent);
            }
        });
    }

}