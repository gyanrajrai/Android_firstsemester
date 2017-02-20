package com.example.admin_gyan.myfirstproject;
import  android.graphics.ImageFormat;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;
        import android.support.v4.view.PagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.util.Log;
        import android.view.View;

        import static android.R.attr.fragment;

/**
 * Created by Admin on 1/4/2017.
 */

public class SwapeActivity extends FragmentActivity {
    ViewPager viewPager;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swapelayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdaptor(fragmentManager));
    }


class MyAdaptor extends FragmentStatePagerAdapter {

    public MyAdaptor(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        Fragment f = null;

        Log.w("Gyanraj", "Fragment f=null");
        if (position == 0) {

            f = new FragmentA();
        }
        if (position == 1) {
            f = new FragMentB();
        }
        if (position == 2) {
            f = new FragMentC();

        }
        return f;
        // Log.d("what value is store in f"+f);


    }

    @Override
    public int getCount() {
        Log.d("gyan", "GetCount is Called");

        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Tab 1";
        }
        if (position == 1) {
            return "Tab 2";

        }
        if (position == 2) {
            return "tab 3";
        }
        return null;
    }
}}

