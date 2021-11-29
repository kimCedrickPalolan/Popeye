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

public class Survey4 extends AppCompatActivity {
    DatabaseHelper db;
    EditText q21,q22A,q22B,q29,etpersonel;
    Button saveHealthInfo,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey4);
        db = new DatabaseHelper(Survey4.this);
        q21 =(EditText) findViewById(R.id.q21);
        q22A =(EditText) findViewById(R.id.q22Birth);
        q22B =(EditText) findViewById(R.id.q22Living);
        q29 =(EditText) findViewById(R.id.q29);
        etpersonel =(EditText) findViewById(R.id.personel3);

//      #place of delivery q19
        Spinner placeOfDelivery = (Spinner) findViewById(R.id.q19);
        ArrayAdapter<String> pod = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.placeOfDelivery));
        pod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeOfDelivery.setAdapter(pod);

//      #personAssistedDelivery q20
        Spinner personAssistedDelivery = (Spinner) findViewById(R.id.q20);
        ArrayAdapter<String> pad = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.personAssistedDelivery));
        pad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personAssistedDelivery.setAdapter(pad);

//      #family planing method q23 and q25
        Spinner fpMethodq23 = (Spinner) findViewById(R.id.q23);
        ArrayAdapter<String> FPMq23 = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fpMethod));
        FPMq23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fpMethodq23.setAdapter(FPMq23);

        Spinner fpMethodq25A = (Spinner) findViewById(R.id.q25A);
        ArrayAdapter<String> FPMq25A = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesNo));
        FPMq25A.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fpMethodq25A.setAdapter(FPMq25A);
        Spinner fpMethodq25B = (Spinner) findViewById(R.id.q25B);
        ArrayAdapter<String> FPMq25B = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fpMethod));
        FPMq25B.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fpMethodq25B.setAdapter(FPMq25B);

//      #sourceOfFP q24
        Spinner sourceOfFP = (Spinner) findViewById(R.id.q24);
        ArrayAdapter<String> SOF = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sourceOfFP));
        SOF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceOfFP.setAdapter(SOF);

//      #healthInsurance q26
        Spinner healthInsurance = (Spinner) findViewById(R.id.q26);
        ArrayAdapter<String> HI = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.healthInsurance));
        HI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        healthInsurance.setAdapter(HI);

//      #familyVisited q27
        Spinner familyVisited = (Spinner) findViewById(R.id.q27);
        ArrayAdapter<String> FI = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.familyVisited));
        FI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyVisited.setAdapter(FI);

//      #reasonOfVisit q28
        Spinner reasonOfVisit = (Spinner) findViewById(R.id.q28);
        ArrayAdapter<String> ROV = new ArrayAdapter<String>(Survey4.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonOfVisit));
        ROV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonOfVisit.setAdapter(ROV);

        saveHealthInfo = (Button) findViewById(R.id.saveHealthInfo);
        saveHealthInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq19 = placeOfDelivery.getSelectedItem().toString();
                String etq20 = personAssistedDelivery.getSelectedItem().toString();
                String etq21 = q21.getText().toString();
                String etq22A = q22A.getText().toString();
                String etq22B = q22B.getText().toString();
                String etq23 = fpMethodq23.getSelectedItem().toString();
                String etq24 = sourceOfFP.getSelectedItem().toString();
                String etq25A = fpMethodq25A.getSelectedItem().toString();
                String etq25B = fpMethodq25B.getSelectedItem().toString();
                String etq26 = healthInsurance.getSelectedItem().toString();
                String etq27 = familyVisited.getSelectedItem().toString();
                String etq28 = reasonOfVisit.getSelectedItem().toString();
                String etq29 = q29.getText().toString();
                String personel = etpersonel.getText().toString();
                String updated_at = " ";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(new Date());

                 if (db.addhealth_info(etq19,etq20,etq21,etq22A,etq22B,etq23,etq24,etq25A,etq25B,etq26,etq27,etq28,etq29,date,updated_at,personel)){
                     Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                 }
            }
        });


        next = (Button) findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Survey4.this, socioCivic.class);
                startActivity(registerIntent);
            }
        });
    }

/*
 q21 =(EditText) findViewById(R.id.q21);
         q22 =(EditText) findViewById(R.id.q22);
         q29 =(EditText) findViewById(R.id.q29);


//      #place of delivery q19
         Spinner placeOfDelivery = (Spinner) findViewById(R.id.q19);
         ArrayAdapter<String> pod = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.placeOfDelivery));
        pod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placeOfDelivery.setAdapter(pod);

//      #personAssistedDelivery q20
        Spinner personAssistedDelivery = (Spinner) findViewById(R.id.q20);
        ArrayAdapter<String> pad = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.personAssistedDelivery));
        pad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personAssistedDelivery.setAdapter(pad);
//      #family planing method q23 and q25

        Spinner fpMethodq23 = (Spinner) findViewById(R.id.q23);
        ArrayAdapter<String> FPMq23 = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fpMethod));
        FPMq23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fpMethodq23.setAdapter(FPMq23);
        Spinner fpMethodq25 = (Spinner) findViewById(R.id.q25);
        ArrayAdapter<String> FPMq25 = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fpMethod));
        FPMq25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fpMethodq25.setAdapter(FPMq25);
//      #sourceOfFP q24
        Spinner sourceOfFP = (Spinner) findViewById(R.id.q24);
        ArrayAdapter<String> SOF = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sourceOfFP));
        SOF.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceOfFP.setAdapter(SOF);
//      #healthInsurance q26
        Spinner healthInsurance = (Spinner) findViewById(R.id.q26);
        ArrayAdapter<String> HI = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.healthInsurance));
        HI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        healthInsurance.setAdapter(HI);
//      #familyVisited q27
        Spinner familyVisited = (Spinner) findViewById(R.id.q27);
        ArrayAdapter<String> FI = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.familyVisited));
        FI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyVisited.setAdapter(FI);
//      #reasonOfVisit q28
        Spinner reasonOfVisit = (Spinner) findViewById(R.id.q28);
        ArrayAdapter<String> ROV = new ArrayAdapter<String>(Survey4.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonOfVisit));
        ROV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonOfVisit.setAdapter(ROV);

//      #save data
        save1 = (Button) findViewById(R.id.save1);
        save1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        String etq19 = placeOfDelivery.getSelectedItem().toString();
        String etq20 = personAssistedDelivery.getSelectedItem().toString();
        String etq21 = q21.getText().toString();
        String etq22 = q22.getText().toString();
        String etq23 = fpMethodq23.getSelectedItem().toString();
        String etq24 = sourceOfFP.getSelectedItem().toString();
        String etq25 = fpMethodq25.getSelectedItem().toString();
        String etq26 = healthInsurance.getSelectedItem().toString();
        String etq27 = familyVisited.getSelectedItem().toString();
        String etq28 = reasonOfVisit.getSelectedItem().toString();
        String etq29 = q29.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String created_at = sdf.format(new Date());

        String updated_at = "";

        if (db.addhealth_info(etq19,etq20,etq21,etq22,etq23,etq24,etq25,etq26,etq27,etq28,etq29,created_at,updated_at)) {
        Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

        } else {
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
        }

        }
        });*/
}