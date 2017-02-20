package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin_GYAN on 12/18/2016.
 */

public class ButtonActionActivity extends Activity {
    int count;
    TextView txtView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//it download
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttom_activity);
        //R static class layout= object


          txtView = (TextView) findViewById(R.id.txtViewNumber);
        Button btnadd = (Button) findViewById(R.id.btn_ADD);
        Button btnSub = (Button) findViewById(R.id.btn_SLB);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtView.setText("Your Counter is: "+count);

            }

        });
        btnSub.setOnClickListener(new View.OnClickListener() {//helper clsss
            public void onClick(View v) {
                count = count - 1;
                txtView.setText(""+count);


            }
        });
    }

}
