package com.example.admin_gyan.sqlitedatabase;

import android.app.Activity;

/**
 * Created by Admin_GYAN on 1/11/2017.
 */

public class PojoClassProductModule extends Activity {
    String cid="";
    String cname="";
    String cpaid="";

    public String getCpaid() {
        return cpaid;
    }

    public void setCpaid(String cpaid) {
        this.cpaid = cpaid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
