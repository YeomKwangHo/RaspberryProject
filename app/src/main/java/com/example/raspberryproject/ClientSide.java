package com.example.raspberryproject;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ��ȣ on 2015-12-03.
 */
public class ClientSide {
    private String html = "";
    private Handler mHandler;

    private Socket mSocket;
    private BufferedReader networkReader;
    private BufferedWriter networkWriter;
    private String Ip = "182.219.118.211";
    private int Port = 4030;

    private Context mContext;


    Person_Data mpersonData;
    boolean mcomePersonData = false;
    boolean mthreadstatus = false;

    ClientSide(Context mContext) {
        this.mContext = mContext;
        mHandler = new Handler();

        checkUpdate.start();
    }

    public void setmpersonData(Person_Data mpersonData) {
        this.mpersonData = mpersonData;

        Toast.makeText(mContext, this.mpersonData.mpersonName, Toast.LENGTH_LONG).show();
        mcomePersonData = true;
    }

    public void setmthreadstatus(boolean setting)
    {
        this.mthreadstatus = setting;
    }

    private Thread checkUpdate = new Thread() {

        public void run() {
            try {
                setSocket(Ip, Port);
                String line;
                Log.w("Step : ", "Start Trhead");

                PrintWriter out = new PrintWriter(networkWriter, true);


                while (true) {

                    // Log.w("1", "1");

//                  if((line = networkReader.readLine()) != null)
//                  {
//                      html = line;
//                      mHandler.post(showUpdate);
//                      Log.i("str", line);
//                  }
                    if (mthreadstatus) {
                        if (mcomePersonData) {
                            out.println(mpersonData.mpersonName + " " + mpersonData.mpersonAge + " " + mpersonData.mpersonSex);
                            mcomePersonData = false;
                        }
                    }
                }

            } catch (Exception e) {
            }
        }
    };

    private Runnable showUpdate = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(mContext, "Coming word : " + html, Toast.LENGTH_SHORT).show();
        }
    };

    public void setSocket(String mIp, int mPort) throws IOException {
        try {
            mSocket = new Socket(mIp, mPort);
            networkReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            networkWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
        } catch (IOException e) {
            Log.i("error : ", "" + e);
            e.printStackTrace();
        }
    }

    public void onClose() {
        try {
            networkWriter.close();
            networkWriter = null;

            mthreadstatus = false;

            mSocket.close();
            mSocket = null;


        } catch (IOException e) {

        }
    }
}
