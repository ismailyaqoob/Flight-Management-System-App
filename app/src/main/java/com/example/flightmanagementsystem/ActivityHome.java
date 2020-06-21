package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
