package com.example.document.new_memo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    Button sav;
    Button clear;
    EditText title;
    EditText topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sav = (Button)findViewById(R.id.save);
        clear = (Button)findViewById(R.id.clear);
        title = (EditText)findViewById(R.id.title);
        topic = (EditText)findViewById(R.id.topic);



        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ti = title.getText().toString();
                String to = topic.getText().toString();

                Calendar calendar = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("EEE , d MMM yyyy, HH:mm");
                String date = df.format(calendar.getTime());

                My_Sql my_sql = new My_Sql(Main2Activity.this);
                SQLiteDatabase database = my_sql.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(My_Sql.COULOMN_TITLE,ti);
                values.put(My_Sql.COULOMN_BODY,to);
                values.put(My_Sql.COULOMN_CREATEAT,date);
                database.insert(My_Sql.TABLE_NAME,null,values);
                Toast.makeText(Main2Activity.this, "saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main2Activity.this , Main22Activity.class);
                startActivity(i);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
