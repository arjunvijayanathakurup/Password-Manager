package com.example.passwordmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "usersdata";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_PASSWORD = "password";
    public static final String CONTACTS_COLUMN_URL = "url";
    public static final String CONTACTS_COLUMN_USER = "userauth";
    private HashMap hp;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table usersdata " + "(id integer primary key, name text, email text, password text, userauth text, url text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usersdata");
        onCreate(db);
    }

    public boolean insertPassword (String name, String email, String password, String userauth, String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("userauth", userauth);
        contentValues.put("url", url);
        db.insert("usersdata", null, contentValues);
        return true;
    }

    public Cursor getData(String name, String userauth) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from usersdata where name = '" + name +"' and userauth = '" + userauth + "'", null );
        return res;
    }

    public boolean updateData (Integer id, String name, String email, String password, String userauth, String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("userauth", userauth);
        contentValues.put("url", url);
        db.update("usersdata", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteData (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("usersdata",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllData() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from usersdata", null );
        if(res!=null && res.getCount()>0){
            res.moveToFirst();

            while(res.isAfterLast() == false){
                array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
                res.moveToNext();
            }
            return array_list;
        }
        else{
            return null;
        }

    }
}
