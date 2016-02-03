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
    private String type;
    private String line;

    private Handler mHandler;

    private Socket mSocket;
    private BufferedReader networkReader;
    private BufferedWriter networkWriter;
    private String Ip = "122.47.118.149";
    private int Port = 4030;

    private Context mContext;

    public ClientSide(Context mContext) {
        this.mContext = mContext;

        this.line = new String();
        this.sendData = new String();
        this.type = new String();

        mHandler = new Handler();
        transferThread.start();
    }


    public void sendingData(String type, String sendData) {
        this.type = type;
        this.sendData = sendData;
        Toast.makeText(mContext, sendData, Toast.LENGTH_SHORT).show();
    }

    private Thread transferThread = new Thread() {

        public void run() {
            try {
                setSocket(Ip, Port);
                Log.w("Step : ", "Start Trhead");
                type = "0";

                PrintWriter out = new PrintWriter(networkWriter, true);

                while (true) {

                    if (type.equals("1")) {
                        sleep(50);
                        out.println(type);

                        if (sendData != null) {
                            out.println(sendData);
                            sendData = null;
                        }

                        type = "0";
                    }

                    else if (type.equals("2")) {
                        out.println(type);

                        while ((line = networkReader.readLine()) != null) Log.w("in : ", line);

                        //mHandler.post(showUpdate);
                        type = "0";
                    }

                }

            } catch (Exception e) {
            }
        }
    };

    private Runnable showUpdate = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(mContext, line, Toast.LENGTH_SHORT).show();
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

    public void close() throws IOException {
        networkWriter.close();
        networkReader.close();
        mSocket.close();

        networkWriter = null;
        networkReader = null;
        mSocket = null;
    }
}
