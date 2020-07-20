package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainLayout extends AppCompatActivity {
    ListView simpleList;
    DBHelper dbHelper;
    private ArrayAdapter arrayAdapter;
    private ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        simpleList = (ListView) findViewById(R.id.listView);
        dbHelper = new DBHelper(this);
        arrayList = dbHelper.getAllData();
        if(arrayList == null){
            Intent intent = new Intent(getApplicationContext(), AddPassword.class);
            startActivity(intent);
        }else{
            arrayAdapter = new ArrayAdapter(this, R.layout.activity_list_layout, arrayList);
            simpleList.setAdapter(arrayAdapter);
        }

    }
}
