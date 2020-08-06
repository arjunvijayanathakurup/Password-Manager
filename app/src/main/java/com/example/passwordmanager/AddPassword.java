package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPassword extends AppCompatActivity {
    EditText name, email, password, username, url;
    Button add;
    PasswordHelper passwordHelper;
    CreateValidatePassword createValidatePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        name = (EditText)findViewById(R.id.nameInsert);
        email = (EditText)findViewById(R.id.emailInsert);
        username = (EditText)findViewById(R.id.usernameInsert);
        password = (EditText)findViewById(R.id.passwordInsert);
        url = (EditText)findViewById(R.id.urlInsert);
        add = (Button)findViewById(R.id.addData);
        passwordHelper = new PasswordHelper(this);
        createValidatePassword = new CreateValidatePassword();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameData = name.getText().toString();
                String emailData  = email.getText().toString();
                String usernameData = username.getText().toString();
                String passwordData = createValidatePassword.createpassword();
                password.setText(passwordData);
                String urlData = url.getText().toString();
                if(passwordHelper.insertPassword(nameData, emailData, usernameData, passwordData, urlData)){
                    Intent intent = new Intent(getApplicationContext(), MainLayout.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AddPassword.this, "Error while inserting password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}