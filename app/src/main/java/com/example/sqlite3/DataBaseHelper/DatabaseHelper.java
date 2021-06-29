package com.example.sqlite3.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import static android.content.ContentValues.TAG;

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

    public Cursor fetchAllData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from DATALIST", null, null);
        while (cursor.moveToNext()) {
            Log.e(TAG, "fetchAllData: ID : " + cursor.getString(0) + "  NAME = : " + cursor.getString(1) + "   Phone = : " + cursor.getString(2) + "  Email = : " + cursor.getString(3));
        }
        return cursor;
    }
    // Get User Details
//    public ArrayList<HashMap<String, String>> GetUsers(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
//        String query = "SELECT NAME,PHONE,EMAIL FROM "+ TABLE_NAME;
//        Cursor cursor = db.rawQuery(query,null);
//        while (cursor.moveToFirst()){
//            HashMap<String,String> user = new HashMap<>();
//            user.put("id",cursor.getString(cursor.getColumnIndex(CAL_1)));
//            user.put("name",cursor.getString(cursor.getColumnIndex(CAL_2)));
//            user.put("phone",cursor.getString(cursor.getColumnIndex(CAL_3)));
//            user.put("email",cursor.getString(cursor.getColumnIndex(CAL_4)));
//            userList.add(user);
//      //      Log.e(TAG, "fetchAllData: ID : " + cursor.getString(0) + "  NAME = : " + cursor.getString(1) + "   Phone = : " + cursor.getString(2) + "  Email = : " + cursor.getString(3));
//        }
//        return  userList;
//    }
//    public List<KYCDataModel> getAlLData() {
//        List<KYCDataModel> notes = new ArrayList<>();
//
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + KYCDataModel.TABLE_NAME + " ORDER BY " +
//                KYCDataModel.COLUMN_NAME + " DESC";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                KYCDataModel kycDataModel = new KYCDataModel();
//                kycDataModel.id = cursor.getInt(cursor.getColumnIndex(KYCDataModel.COLUMN_ID));
//                kycDataModel.name = cursor.getString(cursor.getColumnIndex(KYCDataModel.COLUMN_NAME));
//                kycDataModel.phone = cursor.getString(cursor.getColumnIndex(KYCDataModel.COLUMN_PHONE));
//                notes.add(kycDataModel);
//            } while (cursor.moveToNext());
//        }
//
//        // close db connection
//        db.close();
//
//        // return notes list
//        return notes;
//    }
    public Cursor readAlldata()
    {
        SQLiteDatabase db  = this.getWritableDatabase();
        String qry = "select * from DATALIST order by ID desc";
        Cursor cursor =db.rawQuery(qry,null);
        return cursor;
    }




}
