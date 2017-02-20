package com.itglance.pushnotification.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.itglance.pushnotification.R;

/**
 * Created by Dinesh on 12/12/2016.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("Msg", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("msg2", "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("msg3", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }


        Intent intent= new Intent("update-message");
        Bundle bundle=new Bundle();
        bundle.putString("body",remoteMessage.getNotification().getBody());
        intent.putExtras(bundle);
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notiBuilder=new NotificationCompat.Builder(this);
        notiBuilder.setContentTitle("FCM Notification");
        notiBuilder.setContentText(remoteMessage.getNotification().getBody());
        notiBuilder.setAutoCancel(true);
        notiBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notiBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notiBuilder.build());
    }
}
