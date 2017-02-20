package com.example.admin_gyan.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

/**
 * Created by Admin_GYAN on 1/11/2017.
 */
public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static String DATDABASENANE = "books", ACCOUNTTABLE = "accounttable", MARKETINGTABLE = "marketingtable",
    userinputid="uid",
            ENGLISHTABLE = "engtable",
            customerid = "Cid", customername = "cname", customerPaid = "cPaidamount";


    //    ensures that only objects are added to the arraylist object.
    private ArrayList<PojoClassProductModule> accountinglist = new ArrayList<>();
    private ArrayList<PojoClassProductModule> marketinglist = new ArrayList<>();
    final ArrayList<PojoClassProductModule> englishlist = new ArrayList<>();


    public DatabaseHelperClass(Context context) {
        super(context, DATDABASENANE, null, 44);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS accounttable("

                + "cid INTEGER PRIMARY KEY AUTOINCREMENT," + "uid INTEGER,"+"cname TEXT,"
                + "cPaidamount TEXT");

        db.execSQL("CREATE TABLE IF NOT EXISTS marketingtable("

                + "cid INTEGER PRIMARY KEY AUTOINCREMENT," +"uid,"+ "cname TEXT,"
                + "cPaidamount TEXT");
        db.execSQL("CREATE TABLE IF NOT EXISTS engtable("

                + "cid INTEGER PRIMARY KEY AUTOINCREMENT," + "uid"+"cname TEXT,"
                + "cPaidamount TEXT");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNTTABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + MARKETINGTABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + ENGLISHTABLE);
        onCreate(db);


    }

    public void addInformationAccountong(PojoClassProductModule pojo) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues uses for putting into databse  on the basis of key and values such as map
        ContentValues cv2 = new ContentValues();
        cv2.put("customerid", pojo.cid);
        cv2.put("customername", pojo.cname);
        cv2.put("customerPaid", pojo.getCpaid());
        db.insert("accounttable", null, cv2);
        db.close();

    }

    public ArrayList<PojoClassProductModule> getAccounting() {
        /*
         * get data from database through cursor and pass to class Php to
		 * PojoclassProductModule and Arraylist<>
		 */
        accountinglist.clear();
        SQLiteDatabase db = this.getWritableDatabase();//write this activity class
        Cursor cursor = db.rawQuery("Select * from accounttable", null);
        // Cursor cursor=db.rawQuery("Select student from mytable where id=1",null
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
//creating multiple object through each while loop
                    PojoClassProductModule itemboject = new PojoClassProductModule();
                    itemboject.cid = cursor.getString(cursor
                            .getColumnIndex("Cid"));
                    itemboject.cname = cursor.getString(cursor
                            .getColumnIndex("cname"));
                    itemboject.cpaid = cursor.getString(cursor
                            .getColumnIndex("cPaidamount"));
                    accountinglist.add(itemboject);
                } while (cursor.moveToNext());
            }

        }
        cursor.close();
        db.close();
        return accountinglist;

    }
    public void updateccounting(PojoClassProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv3 = new ContentValues();
        cv3.put("customername", pp.cname);
        cv3.put("customerpaid", pp.cpaid);

        db.update(ACCOUNTTABLE, cv3, "customername=" + pp.cid, null);
        db.close();

    }


    public void deleteAccounting(String id, Object name, Object amt) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from javatable where student = " + id);
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    public void addInfrmationMArketing(PojoClassProductModule pojo) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues uses for putting into databse  on the basis of key and values such as map
        ContentValues cv2 = new ContentValues();
        cv2.put("customerid", pojo.cid);
        cv2.put("customername", pojo.cname);
        cv2.put("customerPaid", pojo.getCpaid());
        db.insert("marketingtable", null, cv2);
        db.close();

    }

    public ArrayList<PojoClassProductModule> getMrakeint() {
        /*
         * get data from database through cursor and pass to class Php to
		 * PojoclassProductModule and Arraylist<>
		 */
        accountinglist.clear();
        SQLiteDatabase db = this.getWritableDatabase();//write this activity class
        Cursor cursor = db.rawQuery("Select * from marketingtable", null);
        // Cursor cursor=db.rawQuery("Select student from mytable where id=1",null
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
//creating multiple object through each while loop
                    PojoClassProductModule itemboject = new PojoClassProductModule();
                    itemboject.cid = cursor.getString(cursor
                            .getColumnIndex("Cid"));
                    itemboject.cname = cursor.getString(cursor
                            .getColumnIndex("cname"));
                    itemboject.cpaid = cursor.getString(cursor
                            .getColumnIndex("cPaidamount"));
                    marketinglist.add(itemboject);
                } while (cursor.moveToNext());
            }

        }
        cursor.close();
        db.close();
        return marketinglist;

    }
    public void updatingMarketing(PojoClassProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv3 = new ContentValues();
        cv3.put("customername", pp.cname);
        cv3.put("customerpaid", pp.cpaid);

        db.update(MARKETINGTABLE, cv3, "customername=" + pp.cid, null);
        db.close();

    }


    public void deleteMaekting(String id, Object name, Object amt) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from marketingtable where student = " + id);
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    public void addInfromationEnglish(PojoClassProductModule pojo) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues uses for putting into databse  on the basis of key and values such as map
        ContentValues cv4 = new ContentValues();
        cv4.put("customerid", pojo.cid);
        cv4.put("customername", pojo.cname);
        cv4.put("customerPaid", pojo.getCpaid());
        db.insert("engtable", null, cv4);
        db.close();

    }

    public ArrayList<PojoClassProductModule> getenglish() {
        /*
         * get data from database through cursor and pass to class Php to
		 * PojoclassProductModule and Arraylist<>
		 */
        englishlist.clear();
        SQLiteDatabase db = this.getWritableDatabase();//write this activity class
        Cursor cursor = db.rawQuery("Select * from engtable", null);
        // Cursor cursor=db.rawQuery("Select student from mytable where id=1",null
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
//creating multiple object through each while loop
                    PojoClassProductModule itemboject = new PojoClassProductModule();
                    itemboject.cid = cursor.getString(cursor
                            .getColumnIndex("Cid"));
                    itemboject.cname = cursor.getString(cursor
                            .getColumnIndex("cname"));
                    itemboject.cpaid = cursor.getString(cursor
                            .getColumnIndex("cPaidamount"));
                    englishlist.add(itemboject);
                } while (cursor.moveToNext());
            }

        }
        cursor.close();
        db.close();
        return englishlist;

    }
    public void updateEnglidh(PojoClassProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv5 = new ContentValues();
        cv5.put("customername", pp.cname);
        cv5.put("customerpaid", pp.cpaid);

        db.update(ENGLISHTABLE, cv5, "customername=" + pp.cid, null);
        db.close();

    }


    public void deleteEnglish(String id, Object name, Object amt) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from engtable where student = " + id);
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }


}
