package com.example.admin_gyan.mysqldatabase1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin_GYAN on 1/17/2017.
 */

public class Login extends Activity implements View.OnClickListener {
   private Button login;
     private static EditText inputuname,inputupassword;
    JSONParser jsonParser=new JSONParser();

    private  static final String url="http://192.168.100.3/webservice/login.php";

    private static final String TAG_SUCCESS="success";
    private static final String TAG_MESSAGE="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login= (Button) findViewById(R.id.btnsend);
        inputupassword= (EditText) findViewById(R.id.editpassword);
        inputuname= (EditText) findViewById(R.id.editusername);
        login.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        new USerCrete().execute();


    }

    private class USerCrete extends AsyncTask <String ,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            AlertDialog alertDialog=new ProgressDialog(Login.this);
            alertDialog.setMessage("Please wait just a minute....");
            alertDialog.setCancelable(false);
            alertDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

           final  String name= inputuname.getText().toString();
            String password=inputupassword.getText().toString();
            try{
                List<NameValuePair> param=new ArrayList<>();
                param.add(new BasicNameValuePair("username",name));
                param.add(new BasicNameValuePair("password",password));
                JSONObject json = jsonParser.makeHttpRequest(url, "POST",param);//return successa nd message from JSONPairser class
                //full json response
                Log.d("registering attempt", json.toString());
                //json success element
               int  success = json.getInt(TAG_SUCCESS);
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
           AlertDialog alert=new ProgressDialog(Login.this);
            alert.dismiss();
            if (file_url != null) {
                Toast.makeText(Login.this, file_url, Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
