package com.example.admin_gyan.mysqldatabase1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin_GYAN on 1/16/2017.
 */

public class Register extends Activity implements View.OnClickListener{
    private EditText user, pass;
    private Button reg;
    //private dialog
    private AlertDialog alertDialog;
    //JSON parser class
    JSONParser jsonParser = new JSONParser();
    //php register script
    //localhost:
    //testing on your device
    //put your local ip instead,on windows,run CMD>ipconfig
    //private static final String REGISter_URL=
    //"http://xxx.xxx.x.x:1234/webservice/register.php;
    //testing on emulator
    private static final String REGISTER_URL = "http://192.168.100.3/webservice/register.php";
    //testing from a real server
    //private static final String REGISTER_URL="http://www.mybringback.com/webservice/register.php"
    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        user = (EditText) findViewById(R.id.secondUsername);
        pass = (EditText) findViewById(R.id.secondpassword);
        reg = (Button) findViewById(R.id.btnsignup);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        new CreateUser().execute();
    }

    class CreateUser extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new ProgressDialog(Register.this);
            alertDialog.setMessage("Creating User....");
            alertDialog.setCancelable(false);
            alertDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            //check for success tag
            int success;
            String username = user.getText().toString().trim();
            String password = pass.getText().toString().trim();
            try {
                //building parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));
                Log.d("request!", "starting");
                //posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(REGISTER_URL, "POST", params);//return successa nd message from JSONPairser class
                //full json response
                Log.d("registering attempt", json.toString());
                //json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("User created!", json.toString());

                    return json.getString(TAG_MESSAGE);

                } else {
                    Log.d("register Failure", json.getString(TAG_MESSAGE));
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String file_url) {//return form json.getString(TAG_MESSAGE
            // TODO Auto-generated method stub
            alertDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

}
