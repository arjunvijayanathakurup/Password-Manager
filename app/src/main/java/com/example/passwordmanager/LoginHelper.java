package com.example.passwordmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "users";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_PASSWORD = "password";
    public static final String CONTACTS_COLUMN_PASSWORD_HINT = "hint";
    public static final String CONTACTS_COLUMN_USER = "username";
    private HashMap hp;

    public LoginHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table users " + "(id integer primary key, username text, email text, password text, hint text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
    public boolean insertPassword (String name, String email, String password, String hint) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("hint", hint);
        db.insert("users", null, contentValues);
        return true;
    }

    public Cursor getData(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users where email = '" + email +"'", null );
        return res;
    }

    public boolean updateData (String email, String password, String username, String hint) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("hint", hint);
        db.update("users", contentValues, "username = ? ", new String[] { username } );
        return true;
    }

    public Integer deleteData (String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users",
                "username = ? ",
                new String[] { username });
    }

}
