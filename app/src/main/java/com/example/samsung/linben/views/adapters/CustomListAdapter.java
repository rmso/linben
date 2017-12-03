package com.example.samsung.linben.views.adapters;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samsung.linben.R;

/**
 * Created by dell on 15/06/2016.
 */

public class CustomListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    SQLiteDatabase db;


    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid){
        super(context, R.layout.list_inicio, itemname);

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_inicio, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description"+itemname[position]);
        return rowView;
    }




}
