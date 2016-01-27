package com.example.raspberryproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ±¤È£ on 2015-12-01.
 */
public class ReceiveFragment extends Fragment {

    Context mContext;

    public ReceiveFragment(){}

    ReceiveFragment(Context mContext)
    {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.receivefragment, container, false);

        return view;
    }
}
