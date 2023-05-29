package com.shrarn.healdeck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Database.db";


    public DBHelper(Context context) {
        super(context, "Database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(patientid TEXT , username TEXT primary key,  dob TEXT, sex TEXT, email TEXT primary key, phone Text, password TEXT, medrep TEXT, character TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String patientid, String username,String dob, String sex, String email, String phone, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("patientid",patientid);
        contentValues.put("username",username);
        contentValues.put("dob",dob);
        contentValues.put("sex",sex);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        contentValues.put("Character",(sex));
        contentValues.put("medrep", ("Cold\nFlu\nDizzy\nAmnesia"));
        long result = MyDB.insert("patients",null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public boolean checkusername(String username)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from patients where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public boolean checkusernamepassword(String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from patients where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
