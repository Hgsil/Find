package com.hgsil.find.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table User{" +
            "id integer primary key," +
            "name text," +
            "try_find text," +
            "password text)";
    public static final String CREATE_FIND = "create table Find{" +
            "id integer primary key," +
            "who_find text ," +
            "introduce text," +
            "contact text)";
    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext =context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
