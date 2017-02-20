package com.example.sumplay.sharedpref;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SUMplay on 9/2/2015.
 */
public class ActivityB extends Activity {

    EditText etUsername;
    EditText etPassword;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb);
        etUsername = (EditText) findViewById(R.id.etbUserName);
        etPassword = (EditText) findViewById(R.id.etbPassword);

    }

    public void Load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
       String name= sharedPreferences.getString("uname",DEFAULT);
        String password=sharedPreferences.getString("upassword",DEFAULT);

        if(name.equals(DEFAULT) || password.equals(DEFAULT)){
        Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Data Successfully Loaded",Toast.LENGTH_SHORT).show();
            etUsername.setText(name);
            etPassword.setText(password);
        }


    }
    public void Previous(View view){
        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
