package com.example.passwordmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class PasswordHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName2.db";
    public static final String PASSWORD_TABLE_NAME = "passwords";
    public static final String PASSWORD_COLUMN_ID = "id";
    public static final String PASSWORD_COLUMN_EMAIL = "email";
    public static final String PASSWORD_COLUMN_PASSWORD = "password";
    public static final String PASSWORD_COLUMN_USER = "username";
    private HashMap hp;

    public PasswordHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table passwords (id integer primary key, name text, username text, email text, password text, url text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS passwords");
        onCreate(db);
    }
    public boolean insertPassword (String name, String email, String username, String password, String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("url", url);
        db.insert("passwords", null, contentValues);
        return true;
    }

    public Cursor getData(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from passwords where name = '" + name +"'", null );
        return res;
    }

    public int getAllData(){
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from passwords", null );
        if(res.moveToFirst()){
            count = 1;
        }else{
            count = 0;
        }
        return count;
    }

    public boolean updateData (String name, String email, String username, String password, String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("url", url);
        db.update("passwords", contentValues, "name = ? ", new String[] { name } );
        return true;
    }

    public Integer deleteData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("passwords",
                "name = ? ",
                new String[] { name });
    }

    public ArrayList<Passwords> getAllDataFrom(){
        ArrayList<Passwords> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery( "select * from passwords", null );
        if(res.moveToFirst()){
            do{
                Passwords passwords = new Passwords();
                passwords.setName(res.getString(0));
                passwords.setUsername(res.getString(1));
                passwords.setMailId(res.getString(2));
                passwords.setPassword(res.getString(3));
                passwords.setUrl(res.getString(4));
                list.add(passwords);
            }
            while (res.moveToNext());
        }
        return list;
    }
}


