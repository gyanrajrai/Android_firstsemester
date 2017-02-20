package com.example.admin_gyan.myapplication;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.BreakIterator;

public class Progresbar extends AppCompatActivity implements AdapterView.OnItemClickListener {
    EditText selectionEditText;
    ListView chooseImageListView;
    String[] imageurlslistt;
    ProgressBar downloadImageProgresbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresbar);


        selectionEditText = (EditText) findViewById(R.id.urlselectionText);
        chooseImageListView = (ListView) findViewById(R.id.chooseImageLisviewt);
        imageurlslistt = getResources().getStringArray(R.array.imageUrls);
        downloadImageProgresbar = (ProgressBar) findViewById(R.id.progressBarbutton);
        chooseImageListView.setOnItemClickListener(this);


    }

    public void downloadImage(View v) {
        BreakIterator selectionEditTextt;
        if (selectionEditText.getText().toString() != null && selectionEditText.getText().toString().length() > 0) {
            MyTask myTask = new MyTask();//Thread // extends AsyTask
            myTask.execute(selectionEditText.getText().toString());
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectionEditText.setText(imageurlslistt[position]);

    }

    private class MyTask extends AsyncTask<String, Integer, Boolean> {
        private int contentlength = -1;
        private int counter = 0;
        private int calculatedProgress = 0;

        @Override
        public void onPreExecute() {
            downloadImageProgresbar.setVisibility(View.VISIBLE);


        }


        @Override
        protected Boolean doInBackground(String... params) {
            boolean successful = false;
            URL downloadURL = null;
            HttpURLConnection connection = null;
            InputStream inputestream = null;//
            FileInputStream fileinputStream = null;//to read
            FileOutputStream fileoutputStream = null;//to write
            File file = null;
            try {
                downloadURL = new URL(params[1]);
                connection = (HttpURLConnection) downloadURL.openConnection();
                contentlength = connection.getContentLength();
              inputestream = connection.getInputStream();
                file = new File(Environment.getExternalStoragePublicDirectory
                        (Environment.DIRECTORY_PICTURES).getAbsolutePath()
                        + "/" + Uri.parse(params[0]).getLastPathSegment());
                fileoutputStream = new FileOutputStream(file);
                //   Log.e("" + "asdfa"+ file.getAbsolutePath());

                int read;
                byte[] buffer = new byte[1024];//creating memory
                while ((read = inputestream.read(buffer)) != -1) {
                    //L.m(""+rJad);
                    fileoutputStream.write(buffer, 0, read);
                    counter = counter + read;
                     Log.e("g","counter"+counter+"length"+contentlength);
                    publishProgress(counter);


                }
                successful = true;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (connection != null) {
                    connection.disconnect();
                }
                if (inputestream != null) {
                    try {
                        inputestream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if (fileoutputStream != null) {
                    try {
                        fileoutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

                return successful;



        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            calculatedProgress= (int)(( (double) values[0]/contentlength)*100);
            downloadImageProgresbar.setProgress(calculatedProgress);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            /*Tosk.makeText() Make a standard toast that just contains a text view with the text from a resource.*/
            downloadImageProgresbar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Download Successful",Toast.LENGTH_LONG).show();/*As the name suggests, it's the context of current state of the application/object.
            It lets newly-created objects understand what has been going on.
             Typically you call it to get information regarding another part of your program (activity and package/application).

You can get the context by invoking getApplicationContext(), getContext(), getBaseContext()
 or this (when in a class that extends from Context, such as the Application, Activity, Service and IntentService classes).*/
        }

    }
}