package com.example.raspberryproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ��ȣ on 2015-12-01.
 */
@SuppressLint("ValidFragment")
public class SendFragment extends Fragment {

    Context mContext;



    SendFragment(Context mContext)
    {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sendfragment,container, false);

        ListView listView = (ListView)view.findViewById(R.id.send_list);

        ArrayList<ListViewItem> data = new ArrayList<>();
        ListViewItem item_personinfo = new ListViewItem("Text");
        ListViewItem item_light = new ListViewItem("Light");

        data.add(item_personinfo);
        data.add(item_light);

        ListViewAdapter adapter = new
                ListViewAdapter(mContext, R.layout.send_listviewlayout, data);
        listView.setAdapter(adapter);

        return view;
    }
}
