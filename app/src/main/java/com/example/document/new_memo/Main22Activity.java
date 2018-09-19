package com.example.document.new_memo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Main22Activity extends AppCompatActivity {

    ArrayList <String> title;
    ArrayList<String>topic;
    ArrayList<String>date;
    ArrayList<Integer>id;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        title = new ArrayList<String>();
        topic = new ArrayList<String>();
        date = new ArrayList<String>();
        id = new ArrayList<Integer>();
        lv = (ListView)findViewById(R.id.list);
        My_Sql db = new My_Sql(this);

        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+My_Sql.TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                id.add(cursor.getInt(cursor.getColumnIndex(My_Sql.COULOMN_ID)));
                title.add(cursor.getString(cursor.getColumnIndex(My_Sql.COULOMN_TITLE)));
                topic.add(cursor.getString(cursor.getColumnIndex(My_Sql.COULOMN_BODY)));
                date.add(cursor.getString(cursor.getColumnIndex(My_Sql.COULOMN_CREATEAT)));
            }while (cursor.moveToNext());
             myAdapter a= new myAdapter(Main22Activity.this,title);
            lv.setAdapter(a);
        }

    }
}
