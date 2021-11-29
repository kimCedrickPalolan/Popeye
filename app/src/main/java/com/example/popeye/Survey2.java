package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Survey2 extends AppCompatActivity  {

    private static final String TAG = "Survey2";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    DatabaseHelper db;
    Button next,back,save;
    TextView tvDate;
    EditText Q1,Q4,brgy,Q6,Q7,Q9,Q10,Q14,etpersonel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);
        db = new DatabaseHelper(Survey2.this);

        brgy =(EditText) findViewById(R.id.brgy);


        Q1 = (EditText)findViewById(R.id.q1);
        Q4 = (EditText)findViewById(R.id.q4);
        Q14 = (EditText)findViewById(R.id.q14);
        Q6 = (EditText)findViewById(R.id.q6);
        Q7 = (EditText)findViewById(R.id.q7);
        Q9 = (EditText)findViewById(R.id.q9);
        Q10 = (EditText)findViewById(R.id.q10);
        tvDate=findViewById(R.id.q5);
        etpersonel=findViewById(R.id.personel1);



        //household head spinner
        Spinner relationship = (Spinner) findViewById(R.id.q2);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.relationship));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relationship.setAdapter(myAdapter);


        //Gender spinner
        Spinner SEX = (Spinner) findViewById(R.id.q3);
        ArrayAdapter<String> sex = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.SEX));
        sex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SEX.setAdapter(sex);

         //marital spinner
        Spinner marital1 = (Spinner) findViewById(R.id.q8);
        ArrayAdapter<String> marital = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.marital));
        marital.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marital1.setAdapter(marital);

        //education spinner
        Spinner Education = (Spinner) findViewById(R.id.q11);
        ArrayAdapter<String> education = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.education));
        education.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Education.setAdapter(education);

        //enroled? spinner
        Spinner Enrolled = (Spinner) findViewById(R.id.q12);
        ArrayAdapter<String> enrolled = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currentEnrolled));
        enrolled.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Enrolled.setAdapter(enrolled);

        //spinner educ level
        Spinner level = (Spinner) findViewById(R.id.q13);
        ArrayAdapter<String> Level = new ArrayAdapter<String>(Survey2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.level));
        Level.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level.setAdapter(Level);





        mDisplayDate = (TextView)findViewById(R.id.q5);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal2 = Calendar.getInstance();
                int y2=cal2.get(Calendar.YEAR);
                int m2=cal2.get(Calendar.MONTH);
                int d2=cal2.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog2 = new DatePickerDialog(Survey2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,y2,m2,d2);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
            }
        });


        mDateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y2, int m2, int d2) {
                m2 = m2+1;
                Log.d(TAG, "onDateSet: yyy/mm/dd" + y2 + "-" + m2 + "-" + d2 );
                String date2 = y2 + "-" + m2 + "-" +d2;
                mDisplayDate.setText(date2);
            }
        };

        save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etQ1 = Q1.getText().toString();
                String etQ2 = relationship.getSelectedItem().toString();
                String etQ3 = SEX.getSelectedItem().toString();
                String etQ4 = Q4.getText().toString();
                String etQ5= tvDate.getText().toString();
                String etQ6 = Q6.getText().toString();
                String etQ7 = Q7.getText().toString();
                String etQ8 = marital1.getSelectedItem().toString();
                String etQ9 = Q9.getText().toString();
                String etQ10 =Q10.getText().toString();
                String etQ11 = Education.getSelectedItem().toString();
                String etbrgy = brgy.getText().toString();
                String etQ12 = Enrolled.getSelectedItem().toString();
                String etQ13 = level.getSelectedItem().toString();
                String etQ14 = Q14.getText().toString();
                String personel = etpersonel.getText().toString();


                String updated_at =  "";
                //current date
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());

                if (db.addDemographic(etQ1,etQ2,etQ3,etQ4,etQ5,etQ6,etQ7,etQ8,etQ9,etQ10,etQ11,etQ12,etQ13,etQ14,etbrgy,created_at,updated_at,personel)) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Survey2.this, Survey3.class);
                startActivity(registerIntent);
            }
        });
    }
}