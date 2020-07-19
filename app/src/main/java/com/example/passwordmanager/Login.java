package com.example.passwordmanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText signedUpEmail, signedUpPassword;
    Button signupButton;
    LoginDatabase loginDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signedUpEmail = (EditText)findViewById(R.id.signupEmail);
        signedUpPassword = (EditText)findViewById(R.id.signupPassword);
        signupButton = (Button)findViewById(R.id.signupButton);

        signupButton.setOnClickListener(view -> {
            if(TextUtils.isEmpty(signedUpEmail.getText().toString())) {
                signedUpEmail.setError("Please enter an Email id");

            }
            else if(TextUtils.isEmpty(signedUpPassword.getText().toString())) {
                signedUpPassword.setError("Please enter an Email id");
            }
            else
            {
                String userName=String.valueOf(signedUpEmail);
                String password=String.valueOf(signedUpPassword);
                String storedpassword = loginDatabase.getSinlgeEntry(userName);
                if(password.equals(storedpassword))
                {
                    Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    //Dialoge dismiss
                }
                else
                {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }


        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDatabase.close();
    }
}