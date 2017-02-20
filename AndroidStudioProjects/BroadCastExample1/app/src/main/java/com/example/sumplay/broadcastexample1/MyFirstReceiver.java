package com.example.sumplay.broadcastexample1;

/**
 * Created by SUMplay on 7/11/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyFirstReceiver extends BroadcastReceiver {
    public static final String TAG = "Fun With Receivers";

    @Override
    public void onReceive(Context ctx, Intent i) {
        Log.i(TAG, "MY_CUSTOM_ACTION Recevied!");
    }
}