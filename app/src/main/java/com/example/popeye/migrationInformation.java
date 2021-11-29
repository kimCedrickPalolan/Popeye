package com.example.popeye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class migrationInformation extends AppCompatActivity {

    private static final String TAG = "migrationInformation";
    Button save,next;
    EditText q33A,q33B,q34A,q34B,q35A,q35B,q37,q39A,q39B,q41,etpersonel;
    DatabaseHelper db;
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migration_information);

        db = new DatabaseHelper(migrationInformation.this);
        q33A = (EditText) findViewById(R.id.q33Brgy);
        q33B = (EditText) findViewById(R.id.q33City);
        q34A = (EditText) findViewById(R.id.q34Brgy);
        q34B = (EditText) findViewById(R.id.q34City);
        q35A = (EditText) findViewById(R.id.q35Month);
        q35B = (EditText) findViewById(R.id.q35Year);
        q39B = (EditText) findViewById(R.id.q39B);
        q41 = (EditText) findViewById(R.id.q41);
        etpersonel = (EditText) findViewById(R.id.personel5);
        tvDate=findViewById(R.id.q37);
        //      #spinner of question 36
        Spinner typeOfResident = (Spinner) findViewById(R.id.q36);
        ArrayAdapter<String> TOR = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.typeOfResident));
        TOR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeOfResident.setAdapter(TOR);

        //      #spinner of question 38A
        Spinner reasonForLeavingA = (Spinner) findViewById(R.id.q38A);
        ArrayAdapter<String> RFLA = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForLeaving));
        RFLA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForLeavingA.setAdapter(RFLA);

        //      #spinner of question 38B
        Spinner reasonForLeavingB = (Spinner) findViewById(R.id.q38B);
        ArrayAdapter<String> RFLB = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForLeaving));
        RFLB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForLeavingB.setAdapter(RFLB);

        //      #spinner of question 38C
        Spinner reasonForLeavingC = (Spinner) findViewById(R.id.q38C);
        ArrayAdapter<String> RFLC = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForLeaving));
        RFLC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForLeavingC.setAdapter(RFLC);

        //      #spinner of question 39
        Spinner yesNo = (Spinner) findViewById(R.id.q39A);
        ArrayAdapter<String> YN = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yesNo));
        YN.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yesNo.setAdapter(YN);

        //      #spinner of question 40A
        Spinner reasonForTransferingA = (Spinner) findViewById(R.id.q40A);
        ArrayAdapter<String> RFTA = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForTransfering));
        RFTA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForTransferingA.setAdapter(RFTA);

        //      #spinner of question 40B
        Spinner reasonForTransferingB = (Spinner) findViewById(R.id.q40B);
        ArrayAdapter<String> RFTB = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForTransfering));
        RFTB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForTransferingB.setAdapter(RFTB);

        //      #spinner of question 40C
        Spinner reasonForTransferingC = (Spinner) findViewById(R.id.q40C);
        ArrayAdapter<String> RFTC = new ArrayAdapter<String>(migrationInformation.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.reasonForTransfering));
        RFTC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reasonForTransferingC.setAdapter(RFTC);

        mDisplayDate1 = (TextView)findViewById(R.id.q37);
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal2 = Calendar.getInstance();
                int y2=cal2.get(Calendar.YEAR);
                int m2=cal2.get(Calendar.MONTH);
                int d2=cal2.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog2 = new DatePickerDialog(migrationInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener1,y2,m2,d2);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
            }
        });
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y2, int m2, int d2) {
                m2 = m2+1;
                Log.d(TAG, "onDateSet: yyy/mm/dd" + y2 + "-" + m2 + "-" + d2 );
                String date2 = y2 + "-" + m2 ;
                mDisplayDate1.setText(date2);
            }
        };
        save = (Button) findViewById(R.id.button3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etq33A = q33A.getText().toString();
                String etq33B = q33B.getText().toString();
                String etq34A = q34A.getText().toString();
                String etq34B = q34B.getText().toString();
                String etq35A = q35A.getText().toString();
                String etq35B = q35B.getText().toString();
                String etq36 = typeOfResident.getSelectedItem().toString();
                String etq37 = tvDate.getText().toString();
                String etq38A = reasonForLeavingA.getSelectedItem().toString();
                String etq38B = reasonForLeavingB.getSelectedItem().toString();
                String etq38C = reasonForLeavingC.getSelectedItem().toString();
                String etq39A = yesNo.getSelectedItem().toString();
                String etq39B = q39B.getText().toString();
                String etq40A = typeOfResident.getSelectedItem().toString();
                String etq40B = typeOfResident.getSelectedItem().toString();
                String etq40C = typeOfResident.getSelectedItem().toString();
                String etq41 = q41.getText().toString();
                String personel = etpersonel.getText().toString();

                String updated_at = "";
//              #created at code
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String created_at = sdf.format(new Date());
                if (db.addMigrationInformation(etq33A, etq33B, etq34A, etq34B, etq35A, etq35B, etq36, etq37, etq38A, etq38B, etq38C, etq39A,etq39B, etq40A, etq40B, etq40C, etq41,created_at,updated_at,personel)) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        });



        next = (Button) findViewById(R.id.button4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(migrationInformation.this, communityTaxCert.class);
                startActivity(registerIntent);
            }
        });
    }
}