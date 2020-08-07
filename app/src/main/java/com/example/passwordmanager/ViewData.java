package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {
    int id;
    TextView name, email, username, password, url;
    Button update, delete;
    PasswordHelper passwordHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        id = getIntent().getExtras().getInt("id");
        name = (TextView)findViewById(R.id.nameValue);
        email = (TextView)findViewById(R.id.emailValue);
        username = (TextView)findViewById(R.id.usernameValue);
        password = (TextView)findViewById(R.id.passwordValue);
        url = (TextView)findViewById(R.id.urlValue);

        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.button2);
        passwordHelper = new PasswordHelper(this);

        Cursor res = passwordHelper.getCurrent(id);
        res.moveToFirst();
            name.setText(res.getString(1).toString());
            email.setText(res.getString(2).toString());
            username.setText(res.getString(3).toString());
            password.setText(res.getString(4).toString());
            url.setText(res.getString(5).toString());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}