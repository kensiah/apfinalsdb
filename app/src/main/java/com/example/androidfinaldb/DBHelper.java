package com.example.androidfinaldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.MessageDigest;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase.db";

    private static final String TABLE_USER = "CREATE TABLE IF NOT EXISTS " + User.TABLE_NAME
            + "(" + User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + User.COLUMN_USERNAME + " TEXT, "
            + User.COLUMN_PASSWORD + " TEXT);";

    private static final String TABLE_ORDER = "CREATE TABLE IF NOT EXISTS " + Car.TABLE_NAME
            + "(" + Car.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Car.COLUMN_MODEL + " TEXT, "
            + Car.COLUMN_VARIANT + " TEXT, "
            + Car.COLUMN_PRICE + " TEXT);";


    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER);
        db.execSQL(TABLE_ORDER);

        //User
        ContentValues values = new ContentValues();
        User user = new User("kensiah","kensiah123");

        values.put(User.COLUMN_ID,user.getId());
        values.put(User.COLUMN_USERNAME,user.getUsername());
        values.put(User.COLUMN_PASSWORD,user.getPassword());
        db.insert(User.TABLE_NAME,null,values);
        //User
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_USERNAME,user.getUsername());
        values.put(User.COLUMN_PASSWORD,user.getPassword());
        db.insert(User.TABLE_NAME,null,values);
        return true;
    }

    public void updateUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_USERNAME,user.getUsername());
        values.put(User.COLUMN_PASSWORD,user.getPassword());
        db.update(User.TABLE_NAME,values,User.COLUMN_ID + " = ? ",
                new String[]{Integer.toString(user.getId())});
    }

    public void deleteUser(Integer id){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(User.TABLE_NAME,User.COLUMN_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<User> getAllUser(){
        ArrayList<User> userArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + User.TABLE_NAME , null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            User user = new User();
            user.setId(res.getInt(res.getColumnIndex(User.COLUMN_ID)));
            user.setUsername(res.getString(res.getColumnIndex(User.COLUMN_USERNAME)));
            user.setPassword(res.getString(res.getColumnIndex(User.COLUMN_PASSWORD)));

            userArrayList.add(user);
            res.moveToNext();
        }
        res.close();
        return userArrayList;
    }

    public boolean insertOrder(Car car) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Car.COLUMN_MODEL,car.getModel());
        values.put(Car.COLUMN_VARIANT,car.getVariant());
        values.put(Car.COLUMN_PRICE,car.getPrice());

        db.insert(Car.TABLE_NAME,null,values);
        return true;
    }

    public void updateOrder(Car car){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Car.COLUMN_MODEL,car.getModel());
        values.put(Car.COLUMN_VARIANT,car.getVariant());
        values.put(Car.COLUMN_PRICE,car.getPrice());

        db.update(Car.TABLE_NAME,values,Car.COLUMN_ID + " = ? ",
                new String[]{Integer.toString(car.getId())});
    }

    public void deleteOrder(Integer id){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(Car.TABLE_NAME,Car.COLUMN_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<Car> getAllOrder(){
        ArrayList<Car> orderArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + Car.TABLE_NAME , null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            Car car = new Car();
            car.setId(res.getInt(res.getColumnIndex(Car.COLUMN_ID)));
            car.setModel(res.getString(res.getColumnIndex(Car.COLUMN_MODEL)));
            car.setVariant(res.getString(res.getColumnIndex(Car.COLUMN_VARIANT)));
            car.setPrice(res.getDouble(res.getColumnIndex(Car.COLUMN_PRICE)));

            orderArrayList.add(car);
            res.moveToNext();
        }
        res.close();
        return orderArrayList;
    }

    private String setSHA256(String x){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(x.getBytes());

            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
