package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InternationalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void GoToInternationalFlightDetail(View v) {
        int cardid = v.getId();
        String name = "";
        if (cardid == R.id.card_america) {
            name = "America";
        } else if (cardid == R.id.card_china) {
            name = "China";
        } else if (cardid == R.id.card_dubai) {
            name = "Dubai";
        } else if (cardid == R.id.card_london) {
            name = "London";
        } else if (cardid == R.id.card_saudiarabia) {
            name = "Saudi Arabia";
        }
        Intent internationaldetail = new Intent();
        internationaldetail.setClass(this, InternationalFlightDetailActivity.class);
        internationaldetail.putExtra("CountryName", name);
        startActivity(internationaldetail);
    }
}
