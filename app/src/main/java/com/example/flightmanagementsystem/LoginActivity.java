package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void GoToDashBoard(View v) {
        Intent signup=new Intent();
        signup.setClass(this, MainActivity.class);
        startActivity(signup);
    }

    public void GoToSignup(View v) {
        Intent signup=new Intent();
        signup.setClass(this, SignupActivity.class);
        startActivity(signup);
    }
}
