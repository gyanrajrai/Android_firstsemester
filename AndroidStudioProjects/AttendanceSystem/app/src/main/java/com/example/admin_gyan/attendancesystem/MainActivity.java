package com.example.admin_gyan.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnhome,btnContact,btnAbout,btnLogin,btnAdmin,btnParent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (  btnhome= (Button) findViewById(R.id.btnhome)).setOnClickListener(this);
        (  btnAbout= (Button) findViewById(R.id.btnaboutus)).setOnClickListener(this);
        ( btnContact= (Button) findViewById(R.id.btnContactus)).setOnClickListener(this);
        (  btnLogin= (Button) findViewById(R.id.btnlogin)).setOnClickListener(this);
        (  btnAdmin= (Button) findViewById(R.id.btnadmin)).setOnClickListener(this);
        (  btnParent= (Button) findViewById(R.id.btnparent)).setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btnhome):
                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);
                break;
            case (R.id.btnContactus):
                Intent intent1=new Intent(MainActivity.this,Contact.class);
                startActivity(intent1);
                break;
            case (R.id.btnaboutus):
                Intent intent2 =new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent2);
                break;
            case (R.id.btnlogin):
                Intent intent3 =new Intent(MainActivity.this,Login.class);
                startActivity(intent3);
                break;
            case (R.id.btnadmin):
                Intent intent4 =new Intent(MainActivity.this,Admin.class);
                startActivity(intent4);
                break;
            case (R.id.btnparent):
                Intent intent5=new Intent(MainActivity.this,Parent.class);
                startActivity(intent5);


            }
        }

    }

