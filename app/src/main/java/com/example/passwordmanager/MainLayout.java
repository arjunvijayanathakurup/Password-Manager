package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainLayout extends AppCompatActivity {
    ListView simpleList;
    String animalList[] = {"Lion","Tiger","Monkey","Elephant","Dog","Cat","Camel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        simpleList = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_layout, R.id.name, animalList);
        simpleList.setAdapter(arrayAdapter);
    }
}