package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeClass extends Activity {
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeclass);//layout chinucha

        et = (EditText) findViewById(R.id.editEnterValue);// alt+enter
        bt = (Button) findViewById(R.id.btnSend);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=et.getText().toString();
                Bundle basket=new Bundle();
                basket.putString("privatekey",message);
                Intent in=new Intent(HomeClass.this,DisplayOfHomeContent.class);
                in.putExtras(basket);
                Log.e("TraceValue",message);


                startActivity(in);

            }
        });

    }



}


