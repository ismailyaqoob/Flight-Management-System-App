package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TicketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView ticketnumbertext,fullnametext,addresstext,mobilenumbertext,NICnumbertext,passportnumbertext,origintext,destinationtext,cabinclasstext,tickettypetext;

        Intent data=getIntent();

        ticketnumbertext=(TextView) findViewById(R.id.textView_TDticketnumber);
        fullnametext=(TextView) findViewById(R.id.textView_TDfullname);
                addresstext=(TextView) findViewById(R.id.textView_TDaddress);
                mobilenumbertext=(TextView) findViewById(R.id.textView_TDmobilenumber);
                NICnumbertext=(TextView) findViewById(R.id.textView_TDNICnumber);
                passportnumbertext=(TextView) findViewById(R.id.textView_TDpasport);
                origintext=(TextView) findViewById(R.id.textView_TDorigin);
                destinationtext=(TextView) findViewById(R.id.textView_TDdestination);
                cabinclasstext=(TextView) findViewById(R.id.textView_TDcabinclass);
                tickettypetext=(TextView) findViewById(R.id.textView_TDtickettype);

                ticketnumbertext.setText(data.getStringExtra("ticketnumber"));
        fullnametext.setText("Full Name: " + data.getStringExtra("fullname"));
        addresstext.setText("Address: " + data.getStringExtra("address"));
        mobilenumbertext.setText("Mobile Number: "+data.getStringExtra("mobilenumber"));
        NICnumbertext.setText("NIC Number: "+data.getStringExtra("NICnumber"));
        passportnumbertext.setText("Passport Number: "+data.getStringExtra("passportnumber"));
        origintext.setText("Origin: "+data.getStringExtra("origin"));
        destinationtext.setText("Destination: "+data.getStringExtra("destination"));
        cabinclasstext.setText("Cabin Class: "+data.getStringExtra("cabinclass"));
        tickettypetext.setText("Ticket Type: "+data.getStringExtra("tickettype"));
    }
}
