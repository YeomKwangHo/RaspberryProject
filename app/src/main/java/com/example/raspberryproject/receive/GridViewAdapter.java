package com.example.raspberryproject.receive;

import android.content.Context;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JISU on 2016-01-28.
 */
public class GridViewAdapter extends BaseAdapter {

    Context context = null;
    ArrayList<String> arrayList;

    public GridViewAdapter(Context context, ArrayList<String> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ButtonView buttonView = new ButtonView(context);

        return buttonView;
    }
}
