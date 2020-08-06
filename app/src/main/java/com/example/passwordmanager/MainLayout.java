package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainLayout extends AppCompatActivity {
    ListView listView;
//    Password List handler
    ArrayList<Passwords> passwordsArrayList = new ArrayList<>();
//    Database handler
    PasswordHelper passwordAdapter = new PasswordHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        listView = (ListView) findViewById(R.id.listView);
        this.passwordsArrayList = passwordAdapter.getAllDataFrom();
        final ArrayList<String> passwordListString = new ArrayList<String>();

        for(Passwords passwords: this.passwordsArrayList){
            String name = passwords.getName();
            String username = passwords.getUsername();
            passwordListString.add(name);
            passwordListString.add(username);
        }
        PasswordAdapter myPassword = new PasswordAdapter(this, R.layout.activity_list_layout, passwordsArrayList);


//        dbHelper = new DBHelper(this);
//        arrayList = dbHelper.getAllData();
//        if(arrayList == null){
//            Intent intent = new Intent(getApplicationContext(), AddPassword.class);
//            startActivity(intent);
//        }else{
//            arrayAdapter = new ArrayAdapter(this, R.layout.activity_list_layout, arrayList);
//            listView.setAdapter(arrayAdapter);
//        }

    }
}

//
//    ArrayList<Passwords> passwordList = new ArrayList<>();
//    private ListView listView;
//    private ArrayAdapter<String> lisAdapter;
//
//
//    final ArrayList<String> passwordList = new ArrayList<String>();
//        this.passwordList = passwordAdapter.getAllDataFrom();
//
//                for(Passwords passwords: this.passwordList){
//                String name = passwords.getName();
//                String username = passwords.getUsername();
//                passwordList.add(name);
//                passwordList.add(username);
//                }
////        lisAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_layout, R.id.username, passwordList);
////        listView.setAdapter(lisAdapter);
//
//                PasswordAdapter passwordAdapter = new PasswordAdapter(this, passwordList)