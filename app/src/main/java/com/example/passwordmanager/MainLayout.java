package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    int id;

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
            id = passwords.getId();
            passwordListString.add(name);
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_layout, R.id.name, passwordListString);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ViewData.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AddPassword.class);

                startActivity(intent);
            }
        });
    }
}

