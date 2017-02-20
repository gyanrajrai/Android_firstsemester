package com.example.admin_gyan.volleystart;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Admin_GYAN on 1/7/2017.
 */
public class Inner extends Activity{
    TextView txtName,txtAddress,txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_itmes);


        txtName = (TextView) findViewById(R.id.txtname2);
        txtAddress = (TextView) findViewById(R.id.txtphone2);
        txtEmail = (TextView) findViewById(R.id.txtemail2);

        String jsonArray=  getIntent().getStringExtra("jsonarray");
        int position = getIntent().getIntExtra("position",0);
        Log.e("array",jsonArray);
        Log.e("arrayposition",""+position);
        try {
            JSONArray jsonArray1 = new JSONArray(jsonArray);//convert Stirng to JSONArray
            for(int i = 0; i<=position;i++){
                JSONObject jsonObject= jsonArray1.getJSONObject(position);
                Log.e("test",""+position);
                txtName.setText(jsonObject.getString("name"));
                txtEmail.setText(jsonObject.getString("email"));
                txtAddress.setText(jsonObject.getString("address"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        String name = getIntent().getStringExtra("name");
//        String email = getIntent().getStringExtra("email");
//        String address = getIntent().getStringExtra("address");









    }

}
