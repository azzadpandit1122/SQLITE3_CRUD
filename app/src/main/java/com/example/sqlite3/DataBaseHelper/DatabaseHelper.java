package com.example.sqlite3.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.sqlite3.model;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static android.os.Build.ID;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "data3.db";
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

    //Inserting DATA in DATABASE SQLITE3
    public boolean InsertData(String Name, String Phone, String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CAL_2, Name);
        contentValues.put(CAL_3, Phone);
        contentValues.put(CAL_4, Email);
        long data = db.insert(TABLE_NAME, null, contentValues);
        if (data == -1) {
            return false;
        } else {
            return true;
        }
    }

    // her use .getWritableDatabase() methods
    // Delete User Details By ID
    public Integer DeleteUserDetails(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[]{Id});

    }

    //Update By User ID
    public boolean UpdateData(String Id, String Name, String Phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAL_1, Id);
        values.put(CAL_2, Name);
        values.put(CAL_3, Phone);
        db.update(TABLE_NAME, values, "ID = ?", new String[]{Id});
        return true;
    }

    //fetch data from Database All colum
    public Cursor readAlldata() {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from " + TABLE_NAME;
        Cursor cursor = null;
        if (db != null) {
        }
        cursor = db.rawQuery(qry, null);
        return cursor;
    }
}

