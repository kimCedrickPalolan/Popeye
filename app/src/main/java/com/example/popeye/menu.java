package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class menu extends AppCompatActivity {
Button survey;
Button logout;
   DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        logout = (Button) findViewById(R.id.logout);
        db = new DatabaseHelper(menu.this);


        logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(menu.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });
        survey = (Button) findViewById(R.id.survey);
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(menu.this, home.class);
                startActivity(registerIntent);

            }
        });
    }
}