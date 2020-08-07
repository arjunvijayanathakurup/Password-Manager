package com.example.passwordmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name, email, username, url, password;
    Button update, delete;
    int id;
    PasswordHelper passwordHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = (EditText) findViewById(R.id.nameInsert);
        email = (EditText) findViewById(R.id.emailInsert);
        username = (EditText) findViewById(R.id.usernameInsert);
        password = (EditText) findViewById(R.id.passwordInsert);
        url = (EditText) findViewById(R.id.urlInsert);
        update = (Button) findViewById(R.id.button);
        delete = (Button) findViewById(R.id.button2);
        id = getIntent().getExtras().getInt("id");
        passwordHelper = new PasswordHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordHelper.updateData(id, name.getText().toString(), email.getText().toString(), username.getText().toString(), password.getText().toString(), url.getText().toString());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Confirm Exit..!!!");
                // Icon Of Alert Dialog
                alertDialogBuilder.setIcon(R.drawable.trashcan);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Are you sure,You want to exit");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(getApplicationContext(), MainLayout.class);
                        startActivity(intent);
                        finish();
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked over No",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}







