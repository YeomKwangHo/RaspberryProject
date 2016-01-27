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
 * Created by ±¤È£ on 2015-12-03.
 */
public class ClientSide {
    private String html = "";
    private Handler mHandler;

    private Socket mSocket;
    private BufferedReader networkReader;
    private BufferedWriter networkWriter;
    private String Ip = "112.157.123.197";
    private int Port = 4030;

    private Context mContext;

    ClientSide(Context mContext) {
        this.mContext = mContext;
        mHandler = new Handler();

        checkUpdate.start();
    }

    private Thread checkUpdate = new Thread(){

        public void run()
      {
          try{
              setSocket(Ip, Port);

              String line;
              Log.w("Step : ", "Start Trhead");

              PrintWriter out = new PrintWriter(networkWriter, true);
              out.println("Connection Commit");

              while(true)
              {
                  if((line = networkReader.readLine()) != null)
                  {
                      html = line;
                      mHandler.post(showUpdate);
                      Log.i("str", line);
                  }
              }
          }catch (Exception e){}
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
        }

        catch (IOException e) {
            Log.i("error : ", "" + e);
            e.printStackTrace();
        }
    }
}
