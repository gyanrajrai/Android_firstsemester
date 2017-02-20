package com.example.sumplay.broadcastexample1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SUMplay on 7/11/2015.
 */
public class MySecondReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "SECOND ACTION RECEIVED", Toast.LENGTH_LONG).show();

    }
}
