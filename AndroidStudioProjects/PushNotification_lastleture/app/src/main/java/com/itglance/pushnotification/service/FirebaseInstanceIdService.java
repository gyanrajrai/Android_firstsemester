package com.itglance.pushnotification.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Dinesh on 12/12/2016.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {
private static final String REG_TOKEN="REG_TOKEN";

    @Override
    public void onTokenRefresh() {

        String recent_token= FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_token);
    }
}
