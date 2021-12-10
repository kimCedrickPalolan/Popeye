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

public class questionForHousehold extends AppCompatActivity {

    EditText Q54A,Q54B,Q55A,Q55B,Q56A,Q56B,Q56C,Q57A,Q57B,Q57C,Q58A,Q58B;
    Button save,next;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_for_household);
        db = new DatabaseHelper(questionForHousehold.this);

        Q54A = findViewById(R.id.q54A);
        Q54B = findViewById(R.id.q54B);
        Q55A = findViewById(R.id.q55A);
        Q55B = findViewById(R.id.q55B);
        Q56A = findViewById(R.id.q56A);
        Q56B = findViewById(R.id.q56B);
        Q56C = findViewById(R.id.q56C);
        Q57A = findViewById(R.id.q57A);
        Q57B = findViewById(R.id.q57B);
        Q57C = findViewById(R.id.q57C);
        Q58A = findViewById(R.id.q58A);
        Q58B = findViewById(R.id.q58B);



        //      #spinner of question 45
        Spinner q45 = (Spinner) findViewById(R.id.q45);
        ArrayAdapter<String> XXXXV = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q45q46));
        XXXXV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q45.setAdapter(XXXXV);

        //      #spinner of question 46
        Spinner q46 = (Spinner) findViewById(R.id.q46);
        ArrayAdapter<String> XXXXVI = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q45q46));
        XXXXVI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q46.setAdapter(XXXXVI);

        //      #spinner of question 47
        Spinner q47 = (Spinner) findViewById(R.id.q47);
        ArrayAdapter<String> XXXXVII = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q47));
        XXXXVII.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q47.setAdapter(XXXXVII);

        //      #spinner of question 36
        Spinner q48 = (Spinner) findViewById(R.id.q48);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q48));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q48.setAdapter(adapter);

        //      #spinner of question 36
        Spinner q49 = (Spinner) findViewById(R.id.q49);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q49));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q49.setAdapter(adapter1);

        //      #spinner of question 36
        Spinner q50A = (Spinner) findViewById(R.id.q50A);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q50A));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q50A.setAdapter(adapter2);

        //      #spinner of question 36
        Spinner q50B = (Spinner) findViewById(R.id.q50B);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q50b));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q50B.setAdapter(adapter3);

        //      #spinner of question 36
        Spinner q51 = (Spinner) findViewById(R.id.q51);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q51));
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q51.setAdapter(adapter4);

        //      #spinner of question 36
        Spinner q52 = (Spinner) findViewById(R.id.q52);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q52));
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q52.setAdapter(adapter5);

        //      #spinner of question 36
        Spinner q53 = (Spinner) findViewById(R.id.q53);
        ArrayAdapter<String> adapter6= new ArrayAdapter<String>(questionForHousehold.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.q53));
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q53.setAdapter(adapter6);



        save = findViewById(R.id.button9);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq45 = q45.getSelectedItem().toString();
                String etq46 = q46.getSelectedItem().toString();
                String etq47 = q47.getSelectedItem().toString();
                String etq48 = q48.getSelectedItem().toString();
                String etq49 = q49.getSelectedItem().toString();
                String etq50A = q50A.getSelectedItem().toString();
                String etq50B = q50B.getSelectedItem().toString();
                String etq51 = q51.getSelectedItem().toString();
                String etq52 = q52.getSelectedItem().toString();
                String etq53 = q53.getSelectedItem().toString();
                String etq54A = Q54A.getText().toString();
                String etq54B = Q54B.getText().toString();
                String etq55A = Q55A.getText().toString();
                String etq55B = Q55B.getText().toString();
                String etq56A = Q56A.getText().toString();
                String etq56B = Q56B.getText().toString();
                String etq56C = Q56C.getText().toString();
                String etq57A = Q57A.getText().toString();
                String etq57B = Q57B.getText().toString();
                String etq57C = Q57C.getText().toString();
                String etq58A = Q58A.getText().toString();
                String etq58B = Q58B.getText().toString();

                String updated_at = "";
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());

                if(db.addQFH(etq45,etq46,etq47,etq48,etq49,etq50A,etq50B,etq51,etq52,etq53,etq54A,etq54B,etq55A,etq55B,etq56A,etq56B,etq56C,etq57A,etq57B,etq57C,etq58A,etq58B,created_at,updated_at)){
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next = (Button) findViewById(R.id.button10);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(questionForHousehold.this, menu.class);
                startActivity(registerIntent);
            }
        });



    }
}