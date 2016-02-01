package com.example.raspberryproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.example.raspberryproject.receive.ButtonView;
import com.example.raspberryproject.receive.GridViewAdapter;

import java.util.ArrayList;

/**
 * Created by ��ȣ on 2015-12-01.
 */
@SuppressLint("ValidFragment")
public class ReceiveFragment extends Fragment {

    Context context;
    ArrayList<String> counter;

    @SuppressLint("ValidFragment")
    ReceiveFragment(Context mContext)
    {
        this.context = mContext;
        counter = new ArrayList<>(); counter.add("1"); counter.add("1"); counter.add("1"); counter.add("1");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.receivefragment, container, false);

        GridView gridView = ((GridView) view.findViewById(R.id.gridView));
        gridView.setAdapter(new GridViewAdapter(context, counter));

        return view;
    }
}
