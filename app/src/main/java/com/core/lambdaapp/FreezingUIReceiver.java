package com.core.lambdaapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FreezingUIReceiver extends BroadcastReceiver {

    private static final String TAG = "FreezyUIReceiver";
    public FreezingUIReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive FREEZING RECEIVER");

        //This is an example of WHAT NOT TO DO !!
        try{
            Thread.sleep(35000);
        }catch(Exception e){}

        Log.d(TAG, "FREEZING RECEIVER END");
    }
}