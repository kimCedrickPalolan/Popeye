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

public class skillsDev extends AppCompatActivity {

    DatabaseHelper db;
    Button save,next;
    EditText q43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_dev);
        db = new DatabaseHelper(skillsDev.this);
        q43 = findViewById(R.id.q43);

        //      #spinner of question 36
        Spinner skill = (Spinner) findViewById(R.id.q44);
        ArrayAdapter<String> sk = new ArrayAdapter<String>(skillsDev.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.skill));
        sk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skill.setAdapter(sk);

        save = (Button) findViewById(R.id.button7);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq43 = q43.getText().toString();
                String etq44 = skill.getSelectedItem().toString();
                String updated_at = "";
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());

                if(db.getSkill(etq43,etq44,created_at,updated_at)){
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next = (Button) findViewById(R.id.button8);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(skillsDev.this, questionForHousehold.class);
                startActivity(registerIntent);
            }
        });
    }
}