package com.example.admin_gyan.myfirstproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Admin_GYAN on 12/20/2016.
 */

public class Menu extends ListActivity {
    String classes[]= {"ButtonActionActivity","MainActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));// connection garne kam garchha


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
String di=classes[position];
        try {
            Class c=Class.forName("com.example.admin_gyan.myfirstproject."+di);
            Log.e("trace class",""+c);
            Intent in=new Intent(Menu.this,c);//bridge between one sreen to another screen
            //intent in=new In
            startActivity(in);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
