package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnquiryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
    }

    public void GoToLocal(View v){
        Intent local =new Intent();
        local.setClass(this, LocalActivity.class);
        startActivity(local);
    }

    public void GoToInternational(View v){
        Intent international =new Intent();
        international.setClass(this, InternationalActivity.class);
        startActivity(international);
    }

}
