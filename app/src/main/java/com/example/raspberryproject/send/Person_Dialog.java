package com.example.raspberryproject.send;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.raspberryproject.R;

/**
 * Created by 광호 on 2015-12-13.
 */
public class Person_Dialog extends Dialog {

    private EditText Edit_Person_name;
    private EditText Edit_Person_age;
    private Button Btn_Confirm;
    private Button Btn_Cancel;
    private RadioButton RBtn_Male;
    private RadioButton RBtn_Female;

    public void init()
    {
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.person_layout);

        Edit_Person_name = (EditText)findViewById(R.id.person_name);
        Edit_Person_age = (EditText)findViewById(R.id.person_age);
        Btn_Confirm = (Button)findViewById(R.id.btn_confirm);
        Btn_Cancel = (Button)findViewById(R.id.btn_cancel);
        RBtn_Male = (RadioButton)findViewById(R.id.RBtn_Male);
        RBtn_Female = (RadioButton)findViewById(R.id.RBtn_Female);


    }

    public Person_Dialog(Context context) {
        super(context);
        init();

        Btn_Confirm.setOnClickListener(mLeftClickListener);
        Btn_Cancel.setOnClickListener(mRightClickListener);
    }

    private View.OnClickListener mLeftClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener mRightClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

}
