package com.example.mohamedsallam.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by Mohamed Sallam on 24-Jan-18.
 */

public class Contract {
    private Contract(){}

    public static final class Entry implements BaseColumns {
        public final static String TABLE_NAME = "Habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_Hibit_Number ="number";


        public final static String COLUMN_Hibit_Name ="name";



    }
}
