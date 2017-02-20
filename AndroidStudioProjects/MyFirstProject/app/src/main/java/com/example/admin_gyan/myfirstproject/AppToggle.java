package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

import static android.R.id.edit;
import static com.example.admin_gyan.myfirstproject.R.id.editview;
import static com.example.admin_gyan.myfirstproject.R.id.txtViewNumber;

/**
 * Created by Admin_GYAN on 12/28/2016.
 */

public class AppToggle extends Activity implements View.OnClickListener {
    Button check;
    ToggleButton tog;
    EditText edt;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apptoggle);

        check = (Button) findViewById(R.id.buttonCheck);
        tog = (ToggleButton) findViewById(R.id.togle);
        edt = (EditText) findViewById(R.id.editview);
        txtview = (TextView) findViewById(R.id.txtDisplay);

        check.setOnClickListener(this);
        tog.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCheck:
                //for hiding text what you are type
                String check = edt.getText().toString();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(edt.getWindowToken(), 0);


                txtview.setText(check);
                Log.e("Test", "I am here" + check);
                if (check.contentEquals("Left")) {
                    txtview.setGravity(Gravity.LEFT);

                } else if (check.contentEquals("Right")) {
                    txtview.setGravity(Gravity.RIGHT);

                } else if (check.contentEquals("centre")) {
                    txtview.setGravity(Gravity.CENTER);

                } else if (check.contentEquals("Blue")) {
                    txtview.setTextColor(Color.BLUE);


                } else if (check.contentEquals("OMJEE")) {

                    Random cray = new Random();
                    txtview.setText("OMG");
                    txtview.setTextColor(Color.rgb(cray.nextInt(255),
                            cray.nextInt(255), cray.nextInt(255)));
                    txtview.setTextSize(cray.nextInt(75));
                    switch (cray.nextInt(3)) {
                        case 0:
                            txtview.setGravity(Gravity.LEFT);
                            break;
                        case 1:
                            txtview.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            txtview.setGravity(Gravity.CENTER);
                            break;
                    }
                } else {
                    txtview.setText("Invalid");
                    txtview.setGravity(Gravity.CENTER);
                    txtview.setTextColor(Color.BLACK);


                }
                break;
            case R.id.togle:
                if (tog.isChecked()) {//on chha vane true0
                    edt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    edt.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }

    }
}
