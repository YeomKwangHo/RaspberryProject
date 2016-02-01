package com.example.raspberryproject.trasfer;

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
    private String sendData;
    private Handler mHandler;

    private Socket mSocket;
    private BufferedReader networkReader;
    private BufferedWriter networkWriter;
    private String Ip = "122.47.118.149";
    private int Port = 4030;

    private Context mContext;

    public ClientSide(Context mContext) {
        this.mContext = mContext;
        mHandler = new Handler();

        checkUpdate.start();
    }


    public void sendingData(String sendData)
    {
            this.sendData = sendData;
            Toast.makeText(mContext, "Send Data ~" , Toast.LENGTH_SHORT).show();
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
                  if(sendData != null)
                  {
                      out.println(sendData);
                      sendData = null;
                  }

                  if((line = networkReader.readLine()) != null)
                  {
//                      html = line;
//                      mHandler.post(showUpdate);
//                      Log.i("str", line);
                  }
              }
          }catch (Exception e){}
      }
    };

//    private Runnable showUpdate = new Runnable() {
//        @Override
//        public void run() {
//            Toast.makeText(mContext, "Coming word : " + html, Toast.LENGTH_SHORT).show();
//        }
//    };

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
