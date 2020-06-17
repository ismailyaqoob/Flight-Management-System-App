package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToHome(View v){
        Intent login =new Intent();
        login.setClass(this, ActivityHome.class);
        startActivity(login);
    }

    public void GoToEnquiry(View v){
        Intent login =new Intent();
        login.setClass(this, EnquiryActivity.class);
        startActivity(login);
    }

    public void GoToBooking(View v){
        Intent bookingactivity =new Intent();
        bookingactivity.setClass(this, BookingActivity.class);
        startActivity(bookingactivity);
    }
}
