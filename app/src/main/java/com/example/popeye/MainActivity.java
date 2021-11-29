package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextUsername = (EditText) findViewById(R.id.etUser);
        mTextPassword = (EditText) findViewById(R.id.etPass);
        mButtonLogin = (Button) findViewById(R.id.btnSave);
        db = new DatabaseHelper(MainActivity.this);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();

                Boolean res = db.checkUser(user,pwd);
                if (res == true) {
                    Intent registerIntent = new Intent(MainActivity.this, menu.class);
                    startActivity(registerIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
                /*Boolean res = db.checkUser(user, pwd);
                if (res == true) {
                    Intent HomePage = new Intent(MainActivity.this, Home.class);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }*/

        });
    }



}