package com.example.admin_gyan.alllistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin_GYAN on 1/6/2017.
 */
public class CollegeDetails extends BaseAdapter {

    private static ArrayList<ItemDetails> collegeDetails;
    private Integer[] imgid = {
            R.drawable.p1,
            R.drawable.bb2,
            R.drawable.p2,
            R.drawable.bb5,
            R.drawable.bb6,
            R.drawable.d1
    };
    private LayoutInflater layoutInflater;

    public CollegeDetails(Context context, ArrayList<ItemDetails> results) {
        collegeDetails = results;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return collegeDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return collegeDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodlderCollege holdercollege;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_details_view, null);
            holdercollege = new ViewHodlderCollege();
            holdercollege.txt_faculty = (TextView) convertView.findViewById(R.id.faculty);
            holdercollege.txtCost = (TextView) convertView.findViewById(R.id.cost);
            holdercollege.txtSemester = (TextView) convertView.findViewById(R.id.semester);

            convertView.setTag(holdercollege);
        } else {
            holdercollege = (ViewHodlderCollege) convertView.getTag();


        }
        return convertView;
    }
}


