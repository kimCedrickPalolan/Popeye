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

public class communityTaxCert extends AppCompatActivity {

    Button save,next;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_tax_cert);

        db = new DatabaseHelper(communityTaxCert.this);

        //      #spinner of question 42A
        Spinner q42A = (Spinner) findViewById(R.id.q42A);
        ArrayAdapter<String> ctcA = new ArrayAdapter<String>(communityTaxCert.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesNo));
        ctcA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q42A.setAdapter(ctcA);
        //      #spinner of question 42A
        Spinner q42B = (Spinner) findViewById(R.id.q42B);
        ArrayAdapter<String> ctcB = new ArrayAdapter<String>(communityTaxCert.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesNo));
        ctcB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q42B.setAdapter(ctcB);

        save = (Button) findViewById(R.id.button5);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq42A = q42A.getSelectedItem().toString();
                String etq42B = q42B.getSelectedItem().toString();
                String updated_at = "";
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());
                if(db.addCommunityCert(etq42A,etq42B,created_at,updated_at)){
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next = findViewById(R.id.button6);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(communityTaxCert.this, skillsDev.class);
                startActivity(registerIntent);
            }
        });
    }
}