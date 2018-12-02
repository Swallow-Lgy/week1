package com.example.week_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    private SQLiteDatabase database;
    public SearchDao(Context context){
        SqlHelper helper = new SqlHelper(context);
        database = helper.getReadableDatabase();
    }
    public void add(String name ,String uuid){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("uuid",uuid);
        database.insert("sreachs",null,values);
    }
    public void del(String uuid){
        database.delete("sreachs","uuid=?" ,new String[]{uuid});
    }
    public List<SearchBean> select(){
        List<SearchBean> list = new ArrayList<>();
        Cursor query = database.query("sreachs", null, null, null, null, null, null,null);
        while (query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            String uuid = query.getString(query.getColumnIndex("uuid"));

            SearchBean searchBean = new SearchBean(name,uuid);
            list.add(searchBean);
        }
        return list;
    }
}
