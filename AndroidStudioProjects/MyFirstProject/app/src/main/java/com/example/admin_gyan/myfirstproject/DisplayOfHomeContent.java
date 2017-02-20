package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Admin_GYAN on 12/21/2016.
 */

public class DisplayOfHomeContent extends Activity {
    TextView setmeassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayofhomecontent);

        setmeassage = (TextView) findViewById(R.id.textdisplay);

        Bundle getbasket = getIntent().getExtras();
        String getValue = getbasket.getString("privatekey");
        setmeassage.setText(getValue);


    }
}
