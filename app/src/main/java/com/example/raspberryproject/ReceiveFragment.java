package com.example.raspberryproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

/**
 * Created by ��ȣ on 2015-12-01.
 */
public class ReceiveFragment extends Fragment {

    Context context;
    int[] imageID = new int[]
            {
                    R.drawable.btn_1,
                    R.drawable.btn_1,
                    R.drawable.btn_1,
                    R.drawable.btn_1,
                    R.drawable.btn_1,
                    R.drawable.btn_1
            };

    public ReceiveFragment(){}



    @SuppressLint("ValidFragment")
    ReceiveFragment(Context mContext)
    {
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.receivefragment, container, false);

        GridView gridView = ((GridView) view.findViewById(R.id.gridView));
        gridView.setAdapter(new GridViewAdapter(context, imageID));

        return view;
    }
}
