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
    private final int NUM_PAGES = 2;
    private final int RECEIVE_PAGE = 0;
    private final int SEND_PAGE = 1;

    // View
    private Switch networkSwitch;
    private Button receiveButton;
    private Button sendButton;
    private boolean oneThread;

    ViewPager mViewPager;

    // ��� Client ����
    ClientSide networkClientSide;
    Context mContext;

    // Fragment
    public SendFragment sendFragment;
    public ReceiveFragment receiveFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        oneThread = true;

        receiveButton = (Button)findViewById(R.id.btn_receive);
        sendButton = (Button)findViewById(R.id.btn_send);

        networkSwitch = (Switch)findViewById(R.id.switch_id);
        networkSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        networkSwitch.setText(getString(R.string.Off));

        // ViewPager에 어뎁터 추가!
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(RECEIVE_PAGE);

        mViewPager.addOnPageChangeListener(onPageChangeListener);

        receiveButton.setSelected(true);
    }

    public void ReceiveClick(View view)
    {
        mViewPager.setCurrentItem(RECEIVE_PAGE);
    }
    public void SendClick(View view)
    {
        mViewPager.setCurrentItem(SEND_PAGE);
    }

    public class pagerAdapter extends FragmentPagerAdapter {
        pagerAdapter(android.support.v4.app.FragmentManager fm){super(fm);}

        @Override
        public Fragment getItem(int position) {

            switch(position)
            {
                case RECEIVE_PAGE :
                    return receiveFragment = new ReceiveFragment(mContext);

                case SEND_PAGE :
                    return sendFragment = new SendFragment(mContext);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int position) {
            receiveButton.setSelected(false);
            sendButton.setSelected(false);

            switch (position) {
                case RECEIVE_PAGE:
                    receiveButton.setSelected(true);
                    break;

                case SEND_PAGE:
                    sendButton.setSelected(true);
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
                networkSwitch.setText(getString(R.string.On));
                if(oneThread) networkClientSide = new ClientSide(mContext);

                oneThread = false;
            }
            else{
                networkSwitch.setText(getString(R.string.Off));
                try {
                    if(!oneThread) {
                        networkClientSide.close();
                        networkClientSide = null;
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
        if(networkClientSide != null)   networkClientSide.sendingData(type, data);
    }
}
