package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin_GYAN on 12/29/2016.
 */

public class Email extends Activity implements View.OnClickListener {
    EditText to, subjectto, from;
    Button btnsend;
    String emailAdd, subject, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.simpleemail);
        to = (EditText) findViewById(R.id.edtemaito);
        subjectto = (EditText) findViewById(R.id.edtemaisubject);
        from = (EditText) findViewById(R.id.edtemailcompose);
        btnsend = (Button) findViewById(R.id.btnemailsend);


        btnsend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        convertEditTextToSstrin();

        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.putExtra(Intent.EXTRA_EMAIL, emailAdd);//this is a key which is
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "LOVE YOU");
        emailintent.setType("plain/text");
        emailintent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(emailintent);


    }

    private void convertEditTextToSstrin() {//converting all Edit text into String

        emailAdd = to.getText().toString();
        subject = subjectto.getText().toString();
        content = from.getText().toString();
    }

}


