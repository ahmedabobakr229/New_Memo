package com.example.document.new_memo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by document on 17/08/2017.
 */

public class My_Sql extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "my_database";
    public static final String TABLE_NAME = "names";
    public static final String COULOMN_ID = "id";
    public static final String COULOMN_TITLE = "title";
    public static final String COULOMN_BODY = "body";
    public static final String COULOMN_CREATEAT = "createat";


    static final int version1 = 1;

    public My_Sql(Context context) {
        super(context, DATABASE_NAME, null, version1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME+ " (" +
                COULOMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COULOMN_TITLE + " TEXT NOT NULL, " +
                COULOMN_BODY + " TEXT NOT NULL, " +
                COULOMN_CREATEAT + " TEXT NOT NULL "+");";
        db.execSQL(SQL_CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      //  onCreate(db);


    }
}
