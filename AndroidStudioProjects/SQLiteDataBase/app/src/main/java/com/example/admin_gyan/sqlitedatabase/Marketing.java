package com.example.admin_gyan.sqlitedatabase;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin_GYAN on 1/11/2017.
 */
public class Marketing extends Activity {
    DatabaseHelperClass db;
    PojoClassProductModule pp;
    ListView listview1;
    TextView textview1;
    Button addbtn;
    private ArrayList<PojoClassProductModule> marketinglist = new ArrayList<PojoClassProductModule>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfildatabase);


        listview1 = (ListView) findViewById(R.id.listofchoice);
        textview1 = (TextView) findViewById(R.id.totalrecordsshow);
        addbtn = (Button) findViewById(R.id.addbutton);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Marketing.this);
                dialog.setContentView(R.layout.dialogboxofaddfieddatabase);
                final EditText editid = (EditText) dialog.findViewById(R.id.id);
                final EditText editn = (EditText) dialog.findViewById(R.id.name);
                final EditText editamount = (EditText) dialog.findViewById(R.id.amount);


                Button add = (Button) dialog.findViewById(R.id.addbtn);
                Button cancel  = (Button) dialog.findViewById(R.id.btncancel);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editid.getText().toString().length() == 0) {
                            Toast.makeText(getApplicationContext(), "INPUT ID", Toast.LENGTH_LONG).show();

                        } else {
                            db = new DatabaseHelperClass(getApplicationContext());
                            db.getWritableDatabase();
                            pp = new PojoClassProductModule();
                            pp.cid = (editid.getText().toString());
                            pp.cname = (editn.getText().toString());
                            pp.cpaid = (editamount.getText().toString());
                            db.addInfrmationMArketing(pp);
                            Toast.makeText(getApplicationContext(),
                                    "Record has been  Successfully Added to marketingtable", Toast.LENGTH_LONG)
                                    .show();


                            dialog.dismiss();
                            onResume();
                        }
                    }

                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });



            }
        });
    }

    public void onResume() {

        // TODO Auto-generated method stub
        super.onResume();
        marketinglist.clear();
        db = new DatabaseHelperClass(getApplicationContext());
        db.getWritableDatabase();
        ArrayList<PojoClassProductModule> moduleArrayList = db.getMrakeint();
        for (int i = 0; i < marketinglist.size(); i++) {

            String customeerid = marketinglist.get(i).getCid();
            String cusmtomerName = marketinglist.get(i).getCname();
            String Amount = marketinglist.get(i).getCpaid();
            PojoClassProductModule pd1 = new PojoClassProductModule();
            pd1.setCid(customeerid);
            pd1.setCname(cusmtomerName);
            pd1.setCpaid(Amount);
            marketinglist.add(pd1);
        }
        textview1.setText("Total Records: " + marketinglist.size());
        listview1.setAdapter(new MarketingView(this));
        db.close();

    }




private class MarketingView extends BaseAdapter {
    LayoutInflater inflate1;

    public MarketingView(Marketing marketing) {
        inflate1 = LayoutInflater.from(marketing);
    }

    @Override
    public int getCount() {
        return marketinglist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder hold = null;
        if (convertView == null) {
            convertView = inflate1.inflate(R.layout.listrecordfromdatbase, null);
            hold = new ViewHolder();
            hold.STUDENTID = (TextView) convertView.findViewById(R.id.getid);
            hold.STUDENTNAME = (TextView) convertView
                    .findViewById(R.id.getname);
            hold.PAIDAMOUNT = (TextView) convertView
                    .findViewById(R.id.getamount);
            convertView.setTag(hold);

        } else {
            hold = (ViewHolder) convertView.getTag();
        }

        hold.STUDENTID.setText(marketinglist.get(position).getCid());
        hold.STUDENTNAME.setText(marketinglist.get(position).getCname());
        hold.PAIDAMOUNT.setText(marketinglist.get(position).getCpaid());
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialogbox1 = new Dialog(Marketing.this);
                dialogbox1.setContentView(R.layout.recordmanipulation);

                final EditText updatename1 = (EditText) dialogbox1
                        .findViewById(R.id.updatename);
                final EditText updateamt1 = (EditText) dialogbox1
                        .findViewById(R.id.updateamount);
                Button updateall = (Button) dialogbox1
                        .findViewById(R.id.update1);
                Button deleteall = (Button) dialogbox1
                        .findViewById(R.id.delete1);
                Button cancelall = (Button) dialogbox1
                        .findViewById(R.id.cancel1);
                dialogbox1.show();
                updateall.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        db = new DatabaseHelperClass(getApplicationContext());
                        db.getWritableDatabase();
                        PojoClassProductModule pp = new PojoClassProductModule();
                        // pp.pid = updateid1.getText().toString();
                            /*
                             * gets updatename1 from user,converts to string and
							 * passes to pp.pname
							 */
                        if (updatename1.getText().toString().length() == 0 || updateamt1.getText().toString().length() == 0) {

                            Toast.makeText(getApplicationContext(), "Input name and paid", Toast.LENGTH_LONG).show();

                        } else {
                            pp.cname = updatename1.getText().toString();
                            pp.cpaid = updateamt1.getText().toString();

                            pp.cid = (marketinglist.get(position).getCid().toString());

                            db.updatingMarketing(pp);
                            db.close();
                            Marketing.this.onResume();
                            dialogbox1.dismiss();
                        }

                    }
                });
                deleteall.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        db.deleteMaekting(marketinglist.get(position).getCid()
                                .toString(), null, null);
                        Marketing.this.onResume();
                        dialogbox1.dismiss();

                    }
                });
                cancelall.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialogbox1.dismiss();

                    }
                });

            }
        });

        return convertView;
    }

    private class ViewHolder {
        public TextView STUDENTID;
        public TextView STUDENTNAME;
        public TextView PAIDAMOUNT;
    }
}
}
