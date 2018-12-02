package com.example.week_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {
    public SqlHelper( Context context) {
        super(context, "Search.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sreachs(id integer primary key autoincrement," +
                "name text," +
                "uuid text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
