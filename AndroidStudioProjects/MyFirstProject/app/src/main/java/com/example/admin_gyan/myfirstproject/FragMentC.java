package com.example.admin_gyan.myfirstproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin_GYAN on 1/4/2017.
 */
public class FragMentC extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //
        return inflater.inflate(R.layout.fragmenta, container, false);
    }
}