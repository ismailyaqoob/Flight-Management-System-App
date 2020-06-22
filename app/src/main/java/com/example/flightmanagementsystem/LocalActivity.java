package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void GoToLocalFlightDetail(View v) {
        int cardid = v.getId();
        String name = "";

        //Checking which button is clicked
        if (cardid == R.id.card_faisalabad) {
            name = "Faisalabad";
        } else if (cardid == R.id.card_islamabad) {
            name = "Islamabad";
        } else if (cardid == R.id.card_karachi) {
            name = "Karachi";
        } else if (cardid == R.id.card_lahore) {
            name = "Lahore";
        } else if (cardid == R.id.card_peshawar) {
            name = "Peshawar";
        }
        Intent localdetail = new Intent();
        localdetail.setClass(this, LocalFlightDetailActivity.class);
        localdetail.putExtra("CityName", name);
        startActivity(localdetail);
    }
}
