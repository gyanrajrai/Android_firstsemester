package com.itglance.pushnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Notification extends AppCompatActivity {

    private TextView showNotificationTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        
        showNotificationTxt= (TextView) findViewById(R.id.notify);
        Bundle bundle=getIntent().getExtras();
        String message=bundle.getString("body");
        showNotificationTxt.setText(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
