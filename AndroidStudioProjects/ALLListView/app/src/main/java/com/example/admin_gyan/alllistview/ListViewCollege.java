package com.example.admin_gyan.alllistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin_GYAN on 1/6/2017.
 */

public class ListViewCollege extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewcollege);
        final ArrayList<FacultyDetails> details = GetSearchResult();
        final ListView list = (ListView) findViewById(R.id.listcollege);

        list.setAdapter((ListAdapter) new FacultyDetails());


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = list.getItemAtPosition(position);
                FacultyDetails collgeDetails = (FacultyDetails) o;
                Toast.makeText(ListViewCollege.this, "You have chosen : " + " " + collgeDetails.getFaculty(), Toast.LENGTH_LONG).show();

            }
        });


    }

    private ArrayList<FacultyDetails> GetSearchResult() {
        ArrayList<FacultyDetails> results = new ArrayList<FacultyDetails>();
        FacultyDetails details = new FacultyDetails();
        details.setFaculty("BBA");
        details.setSemester(8);
        details.setCost(500, 000);
        results.add(details);

        details = new FacultyDetails();
        details.setFaculty("BIT");
        details.setCost(600, 000);
        details.setSemester(8);
        results.add(details);

        details = new FacultyDetails();
        details.setFaculty("BsCIT");
        details.setCost(8940321);
        details.setSemester(8);
        results.add(details);

        details=new FacultyDetails();
        details.setFaculty("Computer Engineering");
        details.setCost(903098093);
        details.setSemester(8);


        details = new FacultyDetails();
        details.setFaculty("Civil Engineering");
        details.setCost(550000);
        details.setSemester(8);
        results.add(details);

        details=new FacultyDetails();
        details.setFaculty("Electronic Engineering");
        details.setCost(903098093);
        details.setSemester(8);


        details = new FacultyDetails();
        details.setFaculty("BBS");
        details.setCost(550000);
        details.setSemester(4);
        results.add(details);

        details=new FacultyDetails();
        details.setFaculty("Nurshing");
        details.setCost(903098093);
        details.setSemester(8);




        return results;
    }

}