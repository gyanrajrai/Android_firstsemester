package com.example.admin_gyan.sqlitedatabase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MianActivity extends Activity {
    TextView accounting,marketing,englishcompostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstclick);
        accounting= (TextView) findViewById(R.id.costaccounting);
        marketing= (TextView) findViewById(R.id.marketing);
        englishcompostion= (TextView) findViewById(R.id.english);
        accounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ac=new Intent(MianActivity.this,Accounting.class);
                startActivity(ac);

            }
        });
        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mar=new Intent(MianActivity.this,Marketing.class);
                startActivity(mar);
            }
        });
        englishcompostion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eng=new Intent(MianActivity.this,English.class);
            }
        });




    }

}
