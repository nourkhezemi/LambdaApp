package com.core.lambdaapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class notFreezingUIReceiver extends BroadcastReceiver {

    private static final String TAG = "FreezyUIReceiver";
    public notFreezingUIReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive not FREEZING RECEIVER!!");




        Log.d(TAG, "not FREEZING RECEIVER END!!");
    }
}