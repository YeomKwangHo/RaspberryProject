package com.example.raspberryproject.send;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.raspberryproject.R;

import java.util.ArrayList;

/**
 * Created by ��ȣ on 2015-12-01.
 */
@SuppressLint("ValidFragment")
public class SendFragment extends Fragment {

    PersonDialog sendInfo;
    Context mContext;
    ArrayList<ListViewItem> data;

    public SendFragment(Context mContext)
    {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sendfragment,container, false);

        setListView();                                              // ListView에 담기 윟나 데이터 초기화
        setDialog();                                                // Text를 보내는 Dialog 초기화
        setAdapter((ListView) view.findViewById(R.id.send_list));  // ListView 어댑터 갱신

        return view;
    }

    public void setListView()
    {
        data = new ArrayList<>();
        ListViewItem item_personInfo = new ListViewItem(this.mContext.getString(R.string.send_personinfo));

        data.add(item_personInfo);
    }

    public void setDialog()
    {
        sendInfo = new PersonDialog(this.mContext);
        sendInfo.setTitle(this.mContext.getString(R.string.Person_Title));
    }

    public void setAdapter(ListView listView) {
        ListViewAdapter adapter = new ListViewAdapter(mContext, R.layout.sendfragment_item, data);
        listView.setAdapter(adapter);
    }
}
