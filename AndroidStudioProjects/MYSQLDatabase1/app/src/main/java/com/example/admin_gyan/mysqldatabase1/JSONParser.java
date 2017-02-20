package com.example.admin_gyan.mysqldatabase1;

import android.app.Activity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Admin_GYAN on 1/16/2017.
 */

public class JSONParser extends Activity{
    String jsonString;
    JSONObject jsonObject;


    InputStream is;

    public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params) {
        //make http request
        try {
            //check for request method
            if (method == "POST") {
                //request method is post
                //defaultHttpClients
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                HttpResponse httpResponse = httpClient.execute(httpPost);//entr gareko browserma
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();//stream aauchha teslai buffereader le read garne


            } else if (method == "GET") { // request method is GET
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);//initialzing is and......
            StringBuilder sb = new StringBuilder();

            //StringBuilder le append garchha  my name gyanraj, my name is append ..
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");

            }
            is.close();

            jsonString = sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            jsonObject = new JSONObject(jsonString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }
}
