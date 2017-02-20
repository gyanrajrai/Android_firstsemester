package com.example.sumplay.broadcastexample1;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Suman on 12/7/2015.
 */
public class PointlessWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Random r = new Random();
        int randomInt = r.nextInt(10);;
        String rand = String.valueOf(randomInt);

        final int N = appWidgetIds.length;
        for(int i = 0 ; i<N; i++){
            int awidgetID = appWidgetIds[i];
            RemoteViews v = new RemoteViews(context.getPackageName(),R.layout.widget);
            v.setTextViewText(R.id.tvwidgetUpdate,rand);
            appWidgetManager.updateAppWidget(awidgetID,v);

        }


    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);

        Toast.makeText(context,"See ya ",Toast.LENGTH_SHORT).show();
    }
}
