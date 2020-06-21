package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int User_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data= getIntent();
        User_ID=data.getIntExtra("userid",0);
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
        Intent booking =new Intent();
        booking.setClass(this, BookingActivity.class);
        booking.putExtra("userid",User_ID);
        startActivity(booking);
    }

    public void GoToViewCancel(View v){
        Intent viewcancel =new Intent();
        viewcancel.setClass(this, ViewCancelActivity.class);
        viewcancel.putExtra("userid",User_ID);
        startActivity(viewcancel);
    }

    public void GoToRating(View v){
        Intent rate =new Intent();
        rate.setClass(this, RatingActivity.class);
        startActivity(rate);
    }

    public void GoToInfo(View v){
        Intent info =new Intent();
        info.setClass(this, infoActivity.class);
        startActivity(info);
    }
}
