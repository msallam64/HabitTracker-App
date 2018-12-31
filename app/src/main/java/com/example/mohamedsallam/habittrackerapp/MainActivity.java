package com.example.mohamedsallam.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DB_Helper mDbhelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbhelper = new DB_Helper(this);
    }

    private void insertPet() {
        SQLiteDatabase db = mDbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.Entry.COLUMN_Hibit_Number, "1");
        values.put(Contract.Entry.COLUMN_Hibit_Name, " walking the dog");
        values.put(Contract.Entry.COLUMN_Hibit_Number, "2");
        values.put(Contract.Entry.COLUMN_Hibit_Name, " taking any medications");


    }

    private void Read() {
        SQLiteDatabase db = mDbhelper.getReadableDatabase();
        String[] projection = {
                Contract.Entry._ID,
                Contract.Entry.COLUMN_Hibit_Number,
                Contract.Entry.COLUMN_Hibit_Name,
        };
         cursor = db.query(
                Contract.Entry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }
    private Cursor ReadFromCursor(){

        try {
            int idColumnIndex = cursor.getColumnIndex(Contract.Entry._ID);
            int numberColumnIndex = cursor.getColumnIndex(Contract.Entry.COLUMN_Hibit_Number);
            int nameColumnIndex = cursor.getColumnIndex(Contract.Entry.COLUMN_Hibit_Name);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentnumber = cursor.getString(numberColumnIndex);
            }
        } finally {

            cursor.close();
        }
        return cursor;
    }
}
