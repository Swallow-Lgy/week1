package com.example.week_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDao  {
    private SQLiteDatabase database;
    public UserDao(Context context){
        SqlHelper helper = new SqlHelper(context);
        database = helper.getReadableDatabase();
    }
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        database.insert("users",null,values);
    }
}
