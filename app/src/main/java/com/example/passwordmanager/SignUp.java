package com.example.passwordmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText signUpEmail, signUpPassword, signUpConfirm, masterPasswordHint;
    Button createAccount;
    LoginDatabase loginDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginDatabase = new LoginDatabase(this);
        loginDatabase = loginDatabase.open();
        setContentView(R.layout.activity_sign_up);
        signUpEmail = (EditText)findViewById(R.id.signupEmail);
        signUpPassword = (EditText)findViewById(R.id.signupPassword);
        signUpConfirm = (EditText)findViewById(R.id.signupPasswordConfirm);
        masterPasswordHint = (EditText)findViewById(R.id.masterPasswordHint);
        createAccount = (Button)findViewById(R.id.signupButton);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(signUpEmail.getText().toString())) {
                    signUpEmail.setError("Please enter an Email id");
                    return;
                }
                if(TextUtils.isEmpty(signUpPassword.getText().toString())) {
                    signUpPassword.setError("Please enter a Password");
                    return;
                }
                if(TextUtils.isEmpty(signUpConfirm.getText().toString())) {
                    signUpConfirm.setError("Please confirm the entered Password");
                    return;
                }
                if(signUpEmail.getText().toString() != null && signUpPassword.getText().toString() != null && signUpPassword.getText().toString().equals(signUpConfirm.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    loginDatabase.insertEntry(String.valueOf(signUpEmail),String.valueOf(signUpPassword));
                    Toast.makeText(getApplicationContext(), "Signed Up, Please Login with the credentials", Toast.LENGTH_LONG).show();
                }
                else{
                    if(!signUpPassword.getText().toString().equals(signUpConfirm.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
    protected void onDestroy() {
        // Auto-generated method stub
        super.onDestroy();
        loginDatabase.close();
    }

}