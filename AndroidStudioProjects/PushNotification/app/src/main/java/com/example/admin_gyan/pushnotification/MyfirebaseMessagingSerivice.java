package com.example.admin_gyan.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Admin_GYAN on 2/2/2017.
 */

public class MyfirebaseMessagingSerivice extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notifationbuilder=new NotificationCompat.Builder(this);
        notifationbuilder.setContentTitle("PEM Notification");
        notifationbuilder.setContentText(remoteMessage.getNotification().getBody());
        System.out.print("My Notification Builder is here::"+notifationbuilder);
        notifationbuilder.setAutoCancel(true);
        notifationbuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifationbuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifationbuilder.build());
    }
}
