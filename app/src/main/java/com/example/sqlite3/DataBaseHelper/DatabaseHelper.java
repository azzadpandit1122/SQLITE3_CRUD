package com.example.sqlite3.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "data2.db";
    public static final String TABLE_NAME = "DATALIST";
    public static final String CAL_1 = "ID";
    public static final String CAL_2 = "NAME";
    public static final String CAL_3 = "PHONE";
    public static final String CAL_4 = "EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Phone INTEGER,Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String Name, String Phone, String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CAL_2, Name);
        contentValues.put(CAL_3, Phone);
        contentValues.put(CAL_4, Email);
        long data = db.insert(TABLE_NAME, null, contentValues);
        if (data == 1) {
            return false;
        } else {
            return true;
        }
    }



}
