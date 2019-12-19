package com.example.androidfinaldb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase.db";

    public CarDBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Contact.TABLE_NAME
                + "(" + Contact.COLUMN_ID + " INTEGER PRIMARY KEY, "
                + Contact.COLUMN_NAME + " TEXT, "
                +  Contact.COLUMN_PHONE_NUMBER + " TEXT)");
    }
}
