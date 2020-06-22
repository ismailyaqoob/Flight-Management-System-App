package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void RateApp(View v) {

        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        Toast.makeText(this, "Your rating: " + ratingbar.getRating(), Toast.LENGTH_LONG).show();
    }
}
