package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainLayout extends AppCompatActivity {
    ListView listView;
    //    Password List handler
    ArrayList<Passwords> passwordsArrayList = new ArrayList<>();
    //    Database handler
    ArrayAdapter<String> listAdapter;
    PasswordHelper passwordAdapter = new PasswordHelper(this);
    ImageView addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        addButton = (ImageView) findViewById(R.id.addPassword);
        listView = (ListView) findViewById(R.id.listView);
        this.passwordsArrayList = passwordAdapter.getAllDataFrom();
        final ArrayList<String> passwordListString = new ArrayList<String>();

        for (Passwords passwords : this.passwordsArrayList) {
            String name = passwords.getName();
            String username = passwords.getUsername();
            passwordListString.add(name);
            passwordListString.add(username);
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_layout, R.id.username, passwordListString);
        listView.setAdapter(listAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AddPassword.class);
                startActivity(intent);
            }
        });
    }
}

