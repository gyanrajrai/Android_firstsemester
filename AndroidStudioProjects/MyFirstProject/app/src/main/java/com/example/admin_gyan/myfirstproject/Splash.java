package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Admin_GYAN on 12/21/2016.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        Thread ta = new Thread() {
            public void run() {
                try {
                    sleep(50000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent it = new Intent(Splash.this, Menu.class);
                startActivity(it);
            }


        };
        ta.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

