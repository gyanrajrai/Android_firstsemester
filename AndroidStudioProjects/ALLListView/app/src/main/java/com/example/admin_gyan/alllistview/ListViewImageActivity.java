package com.example.admin_gyan.alllistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayList<ItemDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter(this, image_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {//for event
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemDetails obj_itemDetails = (ItemDetails)o;
                Toast.makeText(ListViewImageActivity.this, "You have chosen : " + " " + obj_itemDetails.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<ItemDetails> GetSearchResults(){
        ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();//multiple allocating memory

        ItemDetails item_details = new ItemDetails();
        item_details.setName("Pizza");
        item_details.setItemDescription("Spicy Chiken Pizza");
        item_details.setPrice("RS 310.00");
        item_details.setImageNumber(1);
        results.add(item_details);//adding to ArrayList

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Beef Burger");
        item_details.setPrice("RS 350.00");
        item_details.setImageNumber(2);
        results.add(item_details);//adding to ArrayList

        item_details = new ItemDetails();
        item_details.setName("Pizza");
        item_details.setItemDescription("Chiken Pizza");
        item_details.setPrice("RS 250.00");
        item_details.setImageNumber(3);
        results.add(item_details);//adding to ArrayList

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Chicken Burger");
        item_details.setPrice("RS 350.00");
        item_details.setImageNumber(4);
        results.add(item_details);//adding to ArrayList

        item_details = new ItemDetails();
        item_details.setName("Burger");
        item_details.setItemDescription("Fish Burger");
        item_details.setPrice("RS 310.00");
        item_details.setImageNumber(5);
        results.add(item_details);//adding to ArrayList

        item_details = new ItemDetails();
        item_details.setName("Mango");
        item_details.setItemDescription("Mango Juice");
        item_details.setPrice("RS 250.00");
        item_details.setImageNumber(6);
        results.add(item_details);//adding to ArrayList


        return results;
    }
}


