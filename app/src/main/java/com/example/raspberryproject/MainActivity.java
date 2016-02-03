package com.example.raspberryproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.raspberryproject.receive.ReceiveFragment;
import com.example.raspberryproject.send.PersonDialog;
import com.example.raspberryproject.send.SendFragment;
import com.example.raspberryproject.trasfer.ClientSide;

import java.io.IOException;


public class MainActivity extends FragmentActivity {

    // ViewPager ���
    private final int Num_Pages = 2;
    private final int ReceivePage = 0;
    private final int SendPage = 1;


    public PersonDialog mPerson_Dialog;

    // View
    private Switch mSwitch;
    private Button ReceiveButton;
    private Button SendButton;
    private boolean oneThread;

    ViewPager mViewPager;

    // ��� Client ����
    ClientSide socketClientSide;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        oneThread = true;

        ReceiveButton = (Button)findViewById(R.id.btn_receive);
        SendButton = (Button)findViewById(R.id.btn_send);

        mSwitch = (Switch)findViewById(R.id.switch_id);
        mSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        mSwitch.setText(getString(R.string.Off));

        // ViewPager�� �˻��ϰ� Adapter�� �޾��ְ�, ù�������� �����Ѵ�.
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(ReceivePage);

        mViewPager.addOnPageChangeListener(onPageChangeListener);

        mPerson_Dialog = new PersonDialog(mContext);
        mPerson_Dialog.setTitle(getString(R.string.Person_Title));
        ReceiveButton.setSelected(true);
    }

    public void ReceiveClick(View view)
    {
        mViewPager.setCurrentItem(ReceivePage);
    }
    public void SendClick(View view)
    {
        mViewPager.setCurrentItem(SendPage);
    }



    public class pagerAdapter extends FragmentPagerAdapter {

        pagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {

            switch(position)
            {
                case ReceivePage :
                    return new ReceiveFragment(mContext);

                case SendPage :
                    return new SendFragment(mContext);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return Num_Pages;
        }
    }


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int position) {
            ReceiveButton.setSelected(false);
            SendButton.setSelected(false);

            switch (position) {
                case ReceivePage:
                    ReceiveButton.setSelected(true);
                    break;

                case SendPage:
                    SendButton.setSelected(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private Switch.OnCheckedChangeListener onCheckedChangeListener = new Switch.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(isChecked)
            {
                mSwitch.setText(getString(R.string.On));
                if(oneThread) socketClientSide = new ClientSide(mContext);

                oneThread = false;
            }
            else{
                mSwitch.setText(getString(R.string.Off));
                try {
                    if(!oneThread) {
                        socketClientSide.close();
                        socketClientSide = null;
                    }
                    oneThread = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void sendToServer(String type, String data)
    {
        if(socketClientSide != null)   socketClientSide.sendingData(type, data);
    }
}
