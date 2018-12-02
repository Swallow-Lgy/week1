package com.example.week_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SearchDao {
    private SQLiteDatabase database;
    public SearchDao(Context context){
        SqlLiteHelper helper = new SqlLiteHelper(context);
        database = helper.getReadableDatabase();
    }
    public void add(String name,String uuid){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("uuid",uuid);
        database.insert("searchs",null,values);
    }
    public void del(String uuid){
        database.delete("searchs","uuid=?",new String[]{uuid});
    }
}
