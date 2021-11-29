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

public class socioCivic extends AppCompatActivity {

    DatabaseHelper db;
    EditText q32,etpersonel;
    Button save, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socio_civic);
        db = new DatabaseHelper(socioCivic.this);

        q32 = (EditText) findViewById(R.id.q32);
        etpersonel = (EditText) findViewById(R.id.personel8);

//      #place of delivery q30
        Spinner soloParent = (Spinner) findViewById(R.id.q30);
        ArrayAdapter<String> sp = new ArrayAdapter<String>(socioCivic.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.soloParent));
        sp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soloParent.setAdapter(sp);

//      #place of delivery q31
        Spinner yesNo = (Spinner) findViewById(R.id.q31);
        ArrayAdapter<String> yn = new ArrayAdapter<String>(socioCivic.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesNo));
        yn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesNo.setAdapter(yn);

        save = (Button) findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq30 = soloParent.getSelectedItem().toString();
                String etq31 = yesNo.getSelectedItem().toString();
                String etq32 = q32.getText().toString();
                String personel = etpersonel.getText().toString();
                String updated_at = " ";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(new Date());

                if (db.addSocioCivic(etq30, etq31, etq32,date,updated_at,personel)) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }

        });

        next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(socioCivic.this, migrationInformation.class);
                startActivity(registerIntent);
            }
        });
    }
}