package com.example.raspberryproject.send;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.raspberryproject.MainActivity;
import com.example.raspberryproject.R;

/**
 * Created by 광호 on 2015-12-13.
 */
public class PersonDialog extends Dialog {

    MainActivity mainActivity;
    PersonData person_data;

    private EditText Edit_Person_name;
    private EditText Edit_Person_age;
    private Button Btn_Confirm;
    private Button Btn_Cancel;
    private RadioButton RBtn_Female;

    public void init(Context context)
    {
        person_data = new PersonData();
        this.mainActivity = (MainActivity)context;
        setContentView(R.layout.person_layout);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        Edit_Person_name = (EditText)findViewById(R.id.person_name);
        Edit_Person_age = (EditText)findViewById(R.id.person_age);
        Btn_Confirm = (Button)findViewById(R.id.btn_confirm);
        Btn_Cancel = (Button)findViewById(R.id.btn_cancel);
        RBtn_Female = (RadioButton)findViewById(R.id.RBtn_Female);
    }

    public PersonDialog(Context context) {
        super(context);
        init(context);

        Btn_Confirm.setOnClickListener(mLeftClickListener);
        Btn_Cancel.setOnClickListener(mRightClickListener);
    }

    private View.OnClickListener mLeftClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            person_data.setPerson(Edit_Person_name.getText().toString(), Integer.parseInt(Edit_Person_age.getText().toString()), RBtn_Female.isChecked() ? false : true);
            mainActivity.sendToServer("1", person_data.getPerson());

            dismiss();
        }
    };

    private View.OnClickListener mRightClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

}
