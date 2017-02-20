package com.example.admin_gyan.myfirstproject;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Admin_GYAN on 1/3/2017.
 */

public class AndroidTabActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        TabHost tabHost=getTabHost();

        //tab for [phost
        TabHost.TabSpec photospec= tabHost.newTabSpec("photos");
        photospec.setIndicator("photos",getResources().getDrawable(R.drawable.gyanraj));
        Intent photointent=new Intent(this,PhotosActivity.class);
        photospec.setContent(photointent);
    //tab for songs

        TabHost.TabSpec songspec=tabHost.newTabSpec("songs");
        //setting title and icon for the tab
        songspec.setIndicator("song",getResources().getDrawable(R.drawable.common_full_open_on_phone));
        Intent songIntent=new Intent(this,SongsActivity.class);
        songspec.setContent(songIntent);
        // tan for Videos
        TabHost.TabSpec videosSpec=tabHost.newTabSpec("Videos");
        videosSpec.setIndicator("videos",getResources().getDrawable(R.drawable.common_google_signin_btn_icon_dark));
        Intent videosIntent=new Intent(this,VideosActivity.class);
        videosSpec.setContent(videosIntent);

        //adding all TabSpec to TabHost


        TabHost.TabSpec calculatorSpec=tabHost.newTabSpec("calculator");
        calculatorSpec.setIndicator("calculator",getResources().getDrawable(R.drawable.search));
        Intent CalculatorIntent=new Intent(this,CalculatorActivity.class);
        calculatorSpec.setContent(CalculatorIntent);



        tabHost.addTab(photospec);
        tabHost.addTab(songspec);
        tabHost.addTab(videosSpec);
        tabHost.addTab(calculatorSpec);


    }

}
