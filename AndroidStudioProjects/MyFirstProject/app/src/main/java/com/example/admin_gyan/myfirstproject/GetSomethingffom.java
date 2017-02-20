package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


public class GetSomethingffom extends Activity implements View.OnClickListener

{
    Button btn2;
    ImageButton btn1;
    ImageView imgview;
    final static int cameraData=0;
    Intent i;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getsomethingrom);
        btn1=(ImageButton) findViewById(R.id.btn_image);

        btn2= (Button) findViewById(R.id.btn_setwalpeper);
        imgview= (ImageView) findViewById(R.id.picture);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);//point to new Onclicklistener



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_image:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData);
                break;
            case R.id.btn_setwalpeper:

                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }


        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            bmp= (Bitmap) extras.get("data");
            imgview.setImageBitmap(bmp);
    }
}

}
