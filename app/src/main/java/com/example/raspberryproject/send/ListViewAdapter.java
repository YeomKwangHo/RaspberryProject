package com.example.raspberryproject.send;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raspberryproject.MainActivity;
import com.example.raspberryproject.R;

import java.util.ArrayList;

/**
 * Created by ��ȣ on 2015-12-11.
 */
public class ListViewAdapter extends BaseAdapter {

    private final int SEND_PERSONINFO = 0;

    boolean Turn_Light = false;

    private LayoutInflater inflater;
    private ArrayList<ListViewItem> data;
    private MainActivity mainActivity;
    private int layout;

    public ListViewAdapter(Context context, int layout, ArrayList<ListViewItem> data) {
        this.mainActivity = (MainActivity) context;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ListViewItem listViewItem = data.get(position);
        TextView name = (TextView) convertView.findViewById(R.id.list_textview);
        name.setText(listViewItem.getName());

        convertView.setTag(position);
        convertView.setOnClickListener(onClickListener);

        return convertView;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ((int) v.getTag()) {
                case SEND_PERSONINFO:
                    mainActivity.sendFragment.sendInfo.show();
                    break;
            }

        }
    };
}
