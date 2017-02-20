package com.example.admin_gyan.mysqldatabase1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Admin_GYAN on 1/16/2017.
 */

public class SplashButton extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread ta = new Thread() {
            public void run() {
                try {
                    sleep(500);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent it = new Intent(SplashButton.this,CathingSplah.class);
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
