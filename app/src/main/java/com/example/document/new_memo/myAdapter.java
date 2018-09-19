package com.example.document.new_memo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by document on 18/08/2017.
 */

public class myAdapter extends BaseAdapter {

  private Activity context;
    private ArrayList<String>arrayList ;

    public myAdapter(Activity context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = context.getLayoutInflater().inflate(R.layout.row_view,null);
        final Button sh = (Button)view.findViewById(R.id.share);
        final Button ed = (Button)view.findViewById(R.id.edit);
        Button del = (Button)view.findViewById(R.id.delete);
        TextView tv = (TextView)view.findViewById(R.id.textV);
        tv.setText(arrayList.get(position));

        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(i.EXTRA_TEXT,arrayList.get(position));
                i.setType("text/plain");
                context.startActivity(i);
            }
        });
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
