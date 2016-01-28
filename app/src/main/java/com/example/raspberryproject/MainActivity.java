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
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    // ViewPager ���
    private final int Num_Pages = 2;
    private final int ReceivePage = 0;
    private final int SendPage = 1;

    Person_Dialog mPerson_Dialog;

    // View
    private Switch mSwitch;
    private Button ReceiveButton;
    private Button SendButton;

    ViewPager mViewPager;

    // ��� Client ����
    ClientSide SocketClientSide;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        ReceiveButton = (Button)findViewById(R.id.btn_receive);
        SendButton = (Button)findViewById(R.id.btn_send);

        mSwitch = (Switch)findViewById(R.id.switch_id);
        mSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        mSwitch.setText(getString(R.string.Off));

        // ViewPager�� �˻��ϰ� Adapter�� �޾��ְ�, ù�������� �����Ѵ�.
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(ReceivePage);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        });

        mPerson_Dialog = new Person_Dialog(mContext);
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


    private Switch.OnCheckedChangeListener onCheckedChangeListener = new Switch.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(isChecked)
            {
                mSwitch.setText(getString(R.string.On));
                SocketClientSide = new ClientSide(mContext);
            }
            else{
                mSwitch.setText(getString(R.string.Off));
                SocketClientSide = null;
            }
        }
    };
}
