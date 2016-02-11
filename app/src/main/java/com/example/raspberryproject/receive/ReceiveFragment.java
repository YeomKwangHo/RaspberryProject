package com.example.raspberryproject.receive;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.raspberryproject.MainActivity;
import com.example.raspberryproject.R;
import com.example.raspberryproject.receive.ButtonView;
import com.example.raspberryproject.receive.GridViewAdapter;

import java.util.ArrayList;

/**
 * Created by ��ȣ on 2015-12-01.
 */
@SuppressLint("ValidFragment")
public class ReceiveFragment extends Fragment {

    Context context;
    MainActivity mainActivity;
    ArrayList<String> counter;


    @SuppressLint("ValidFragment")
    public ReceiveFragment(Context mContext)
    {
        this.context = mContext;
        this.mainActivity = (MainActivity)mContext;
        counter = new ArrayList<>(); counter.add("1"); counter.add("1"); counter.add("1"); counter.add("1");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.receivefragment, container, false);

        GridView gridView = ((GridView) view.findViewById(R.id.gridView));
        gridView.setAdapter(new GridViewAdapter(context, counter));
        gridView.setOnItemClickListener(onItemClickListener);

        return view;
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            if(position == 0)
            {
                mainActivity.sendToServer("2", "Hello");
            }
        }
    };
}
