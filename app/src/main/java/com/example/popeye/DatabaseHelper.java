package com.example.popeye;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME ="popeye_db";
        public static final int DATABASE_VERSION = 1;
        public final Context context;
        public static final String table12 = "users";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
        String bookletinfo = "CREATE TABLE bookletinfo ( booklet_id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, type VARCHAR NOT NULL, province VARCHAR NOT NULL, citymunicipality NOT NULL, barangay VARCHAR NOT NULL, address VARCHAR NOT NULL, respondent_name VARCHAR NOT NULL, household_head VARCHAR NOT NULL, hh_mem_count INTEGER NOT NULL, created_at DATETIME NOT NULL, updated_at TIMESTAMP,user_id VARCHAR)";
        String communitytaxcertificate = "CREATE TABLE communitytaxcertificate (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q42A VARCHAR, Q42B VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String demographiccharacteristics = "CREATE TABLE demographiccharacteristics (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q1 VARCHAR , Q2 VARCHAR , Q3 VARCHAR , Q4 INTEGER , Q5 DATE , Q6 VARCHAR , Q7 VARCHAR , Q8 VARCHAR , Q9 VARCHAR , Q10 VARCHAR , Q11 VARCHAR , Q12 VARCHAR , Q13 VARCHAR , Q14 VARCHAR , currentbrgy VARCHAR , created_at TIMESTAMP  , updated_at TIMESTAMP, user_id VARCHAR)";
        String economicactivity = "CREATE TABLE economicactivity (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q15 REAL, Q16 VARCHAR, Q17 VARCHAR, Q18 VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String health_info = "CREATE TABLE health_info (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q19 VARCHAR, Q20 VARCHAR, Q21 VARCHAR, Q22Births INTEGER, Q22Living INTEGER, Q23 VARCHAR, Q24 VARCHAR, Q25A VARCHAR, Q25B VARCHAR, Q26 VARCHAR, Q27 VARCHAR, Q28 VARCHAR, Q29 VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String skillsdevelopment = "CREATE TABLE skillsdevelopment (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q43 VARCHAR, Q44 VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String sociocivicparticipation = "CREATE TABLE sociocivicparticipation (id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q30 VARCHAR, Q31 VARCHAR, Q32 VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String migrationinfo = "CREATE TABLE migrationinfo(id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q33BrgyDesc VARCHAR, Q33CityMunDesc VARCHAR, Q34BrgyDesc VARCHAR, Q34CityMunDesc VARCHAR, Q35M INT NOT NULL, Q35Y INT NOT NULL, Q36 VARCHAR, Q37 DATE, Q38A VARCHAR, Q38B VARCHAR, Q38C VARCHAR, Q39Answer VARCHAR, Q39Response, Q40A VARCHAR, Q40B VARCHAR, Q40C VARCHAR, Q41 VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String householdquestions = "CREATE TABLE householdquestions(id INTEGER PRIMARY  KEY AUTOINCREMENT NOT NULL, Q45 VARCHAR, Q46 VARCHAR, Q47 VARCHAR, Q48 VARCHAR, Q49 VARCHAR, Q50A VARCHAR, Q50B VARCHAR, Q51 VARCHAR, Q52 VARCHAR , Q53 VARCHAR, Q54AGE INT, Q54COD VARCHAR, Q55AGE INT, Q55COD VARCHAR, Q56A VARCHAR, Q56B VARCHAR, Q56C VARCHAR, Q57A VARCHAR, Q57B VARCHAR, Q57C VARCHAR, Q58CityMun VARCHAR, Q58Province VARCHAR, created_at TIMESTAMP, updated_at TIMESTAMP, user_id VARCHAR)";
        String users = "create table "+table12+"(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, role_id INTEGER, name VARCHAR, email VARCHAR, avatar CARCHAR, email_verified_at TIMESTAMP, password VARCHAR,remember_token VARCHAR, settings VARCHAR,created_at TIMESTAMP, update_at TIMESTAMP)";

            db.execSQL(bookletinfo);
            db.execSQL(communitytaxcertificate);
            db.execSQL(demographiccharacteristics);
            db.execSQL(economicactivity);
            db.execSQL(health_info);
            db.execSQL(skillsdevelopment);
            db.execSQL(sociocivicparticipation);
            db.execSQL(migrationinfo);
            db.execSQL(householdquestions);
            db.execSQL(users);
        db.execSQL("INSERT into "+table12+" (role_id, name, email, avatar, password,remember_token, settings) Values(' ','admin','admin@gmail.com',' ','admin',' ',' ')");
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bookletinfo");
        db.execSQL("DROP TABLE IF EXISTS communitytaxcertificate");
        db.execSQL("DROP TABLE IF EXISTS demographiccharacteristics");
        db.execSQL("DROP TABLE IF EXISTS economicactivity");
        db.execSQL("DROP TABLE IF EXISTS healthinfo");
        db.execSQL("DROP TABLE IF EXISTS skillsdevelopment");
        db.execSQL("DROP TABLE IF EXISTS sociocivicparticipation");
        db.execSQL("DROP TABLE IF EXISTS migrationinfo");
        db.execSQL("DROP TABLE IF EXISTS householdquestions");
        db.execSQL("DROP TABLE IF EXISTS "+table12);
        onCreate(db);
    }

    public boolean checkUser(String name, String pwd){
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = "name" + "=?" + " and " + "password" + "=?";
        String[] selectionArgs = { name, pwd };
        Cursor cursor = db.query(table12,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }

    public boolean addBooklet(String type1, String province, String municipality, String barangay, String address, String nameofrespondent,
                              String householdhead, String householdtotal, String date, String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("type",type1);
        contentValues.put("province",province);
        contentValues.put("citymunicipality",municipality);
        contentValues.put("barangay",barangay);
        contentValues.put("address",address);
        contentValues.put("respondent_name",nameofrespondent);
        contentValues.put("household_head",householdhead);
        contentValues.put("hh_mem_count", householdtotal);
        contentValues.put("created_at", date);
        contentValues.put("updated_at", updated_at);

        db.insert("bookletinfo",null,contentValues);
        return true;
        }


    public boolean addDemographic(String etQ1,String etQ2,String etQ3,String etQ4,String etQ5,String etQ6,String etQ7,String etQ8,String etQ9, String etQ10,
                                  String etQ11,String etQ12,String etQ13,String etQ14, String etbrgy,String created_at,String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Q1",etQ1);
        contentValues.put("Q2",etQ2);
        contentValues.put("Q3",etQ3);
        contentValues.put("Q4",etQ4);
        contentValues.put("Q5",etQ5);
        contentValues.put("Q6",etQ6);
        contentValues.put("Q7", etQ7);
        contentValues.put("Q8",etQ8);
        contentValues.put("Q9",etQ9);
        contentValues.put("Q10",etQ10);
        contentValues.put("Q11",etQ11);
        contentValues.put("Q12",etQ12);
        contentValues.put("Q13",etQ13);
        contentValues.put("Q14", etQ14);
        contentValues.put("currentbrgy",etbrgy);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at", updated_at);

       db.insert("demographiccharacteristics",null,contentValues);
       return true;

    }

    public boolean addeconomic(String q15,String q16,String q17,String q18,String created_at,String updated_at){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Q15",q15);
        contentValues.put("Q16",q16);
        contentValues.put("Q17",q17);
        contentValues.put("Q18",q18);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at", updated_at);

        db.insert("economicactivity",null,contentValues);
        return true;
    }

    public boolean addhealth_info(String etq19, String etq20, String etq21, String etq22A,String etq22B, String etq23, String etq24, String etq25A,
                                  String etq25B, String etq26, String etq27, String etq28, String etq29,String date,String updated_at){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Q19",etq19);
        contentValues.put("Q20",etq20);
        contentValues.put("Q21",etq21);
        contentValues.put("Q22Births",etq22A);
        contentValues.put("Q22Living",etq22B);
        contentValues.put("Q23",etq23);
        contentValues.put("Q24",etq24);
        contentValues.put("Q25A",etq25A);
        contentValues.put("Q25B",etq25B);
        contentValues.put("Q26",etq26);
        contentValues.put("Q27",etq27);
        contentValues.put("Q28",etq28);
        contentValues.put("Q29",etq29);
        contentValues.put("created_at",date);
        contentValues.put("updated_at", updated_at);

        db.insert("health_info",null,contentValues);
        return true;
    }

    public boolean addSocioCivic(String etq30, String etq31, String etq32,String date,String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Q30",etq30);
        contentValues.put("Q31",etq31);
        contentValues.put("Q32",etq32);
        contentValues.put("created_at",date);
        contentValues.put("updated_at", updated_at);

        db.insert("sociocivicparticipation",null,contentValues);
        return true;
    }

    public boolean addMigrationInformation(String etq33A, String etq33B, String etq34A, String etq34B, String etq35A, String etq35B, String etq36,
                                           String etq37, String etq38A, String etq38B, String etq38C, String etq39A, String etq39B, String etq40A,
                                           String etq40B, String etq40C, String etq41, String created_at, String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("Q33BrgyDesc",etq33A);
        contentValues.put("Q33CityMunDesc",etq33B);
        contentValues.put("Q34BrgyDesc",etq34A);
        contentValues.put("Q34CityMunDesc",etq34B);
        contentValues.put("Q35M",etq35A);
        contentValues.put("Q35Y",etq35B);
        contentValues.put("Q36",etq36);
        contentValues.put("Q37",etq37);
        contentValues.put("Q38A",etq38A);
        contentValues.put("Q38B",etq38B);
        contentValues.put("Q38C",etq38C);
        contentValues.put("Q39Answer",etq39A);
        contentValues.put("Q39Response",etq39B);
        contentValues.put("Q40A",etq40A);
        contentValues.put("Q40B", etq40B);
        contentValues.put("Q40C",etq40C);
        contentValues.put("Q41",etq41);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at",updated_at);


        db.insert("migrationinfo",null,contentValues);
    return true;
    }

    public boolean addCommunityCert(String etq42A, String etq42B, String created_at, String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("Q42A",etq42A);
        contentValues.put("Q42B",etq42B);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at",updated_at);

        db.insert("communitytaxcertificate",null,contentValues);
        return true;
    }

    public boolean getSkill(String etq43, String etq44, String created_at, String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Q43",etq43);
        contentValues.put("Q44",etq44);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at",updated_at);

        db.insert("skillsdevelopment",null,contentValues);
        return true;
    }

    public boolean addQFH(String etq45, String etq46, String etq47, String etq48, String etq49, String etq50A, String etq50B, String etq51, String etq52,
                          String etq53, String etq54A, String etq54B, String etq55A, String etq55B, String etq56A, String etq56B, String etq56C,
                          String etq57A, String etq57B, String etq57C, String etq58A, String etq58B, String created_at, String updated_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Q45",etq45);
        contentValues.put("Q46",etq46);
        contentValues.put("Q47",etq47);
        contentValues.put("Q48",etq48);
        contentValues.put("Q49",etq49);
        contentValues.put("Q50A",etq50A);
        contentValues.put("Q50B",etq50B);
        contentValues.put("Q51",etq51);
        contentValues.put("Q52",etq52);
        contentValues.put("Q53",etq53);
        contentValues.put("Q54AGE",etq54A);
        contentValues.put("Q54COD",etq54B);
        contentValues.put("Q55AGE",etq55A);
        contentValues.put("Q55COD",etq55B);
        contentValues.put("Q56A",etq56A);
        contentValues.put("Q56B",etq56C);
        contentValues.put("Q56C",etq56B);
        contentValues.put("Q57A",etq57A);
        contentValues.put("Q57B",etq57B);
        contentValues.put("Q57C",etq57C);
        contentValues.put("Q58CityMun",etq58A);
        contentValues.put("Q58Province",etq58B);
        contentValues.put("created_at",created_at);
        contentValues.put("updated_at",updated_at);


        db.insert("householdquestions",null,contentValues);
        return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table12,null);
        return res;
    }
}
