package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Admin_GYAN on 12/27/2016.
 */

public class Browser extends Activity implements View.OnClickListener {
    EditText url;
    WebView webView;
    Button go, back, refresh, forward, clarhistory;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        url = (EditText) findViewById(R.id.editbrowser);
        webView = (WebView) findViewById(R.id.wvBrowser);
        go= (Button) findViewById(R.id.button1);
        back= (Button) findViewById(R.id.button2);
        refresh= (Button) findViewById(R.id.button3);
        forward= (Button) findViewById(R.id.button4);
       clarhistory = (Button) findViewById(R.id.button5);

        webView.setWebViewClient(new WebViewClient());
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);// for zooming
        webView.getSettings().setUseWideViewPort(true);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        refresh.setOnClickListener(this);
        forward.setOnClickListener(this);
        clarhistory.setOnClickListener(this);


           }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String theWebsite=url.getText().toString();
                webView.loadUrl("https://www."+theWebsite);
                //hiding the keyword after using the on EditText
                InputMethodManager so= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                so.hideSoftInputFromWindow(url.getWindowToken(),0);
                break;
            case R.id.button2:
                if(webView.canGoBack())
                    webView.goBack();
                break;
            case R.id.button3:
                if(webView.canGoForward())
                    webView.goForward();
                break;
            case R.id.button4:
                webView.reload();
                break;
            case R.id.button5:
                webView.clearHistory();
                break;




        }

    }

    }

