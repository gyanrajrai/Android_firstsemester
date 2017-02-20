package com.example.admin_gyan.mysqldatabase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CathingSplah extends AppCompatActivity {

    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userslelect);
        b1 = (Button) findViewById(R.id.btnregister);
        b2 = (Button) findViewById(R.id.btnupdate);
        b3 = (Button) findViewById(R.id.btnlogin);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(CathingSplah.this, Register.class);
                startActivity(in);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CathingSplah.this,Login.class);
                startActivity(in);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CathingSplah.this,Update.class);
                startActivity(in);
            }
        });


    }

}
