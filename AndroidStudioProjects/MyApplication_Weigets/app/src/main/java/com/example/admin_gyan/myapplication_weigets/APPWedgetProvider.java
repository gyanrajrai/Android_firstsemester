package com.example.admin_gyan.myapplication_weigets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Arrays;

/**
 * Created by Admin_GYAN on 1/22/2017.
 */

public class APPWedgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds){
        final int N=appWidgetIds.length;


        Log.i("APPWegets","upadating widgets"+ Arrays.asList(appWidgetIds));
        //perform this loop procesure for ecach App Widget that belongs to this
        //provider

        for(int i=0;i<N;i++){
            int appWidgetId=appWidgetIds[i];

            Intent inten=new Intent(context,MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,inten,0);
//get the layput for the app widget and attach an on-click listener to the bttuon

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.wedget);
            views.setOnClickPendingIntent(R.id.buttton,pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId,views);
        }

    }
}
