package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LocalFlightDetailActivity extends AppCompatActivity {

    String cityname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_flight_detail);

        Intent data=getIntent();
        cityname=data.getStringExtra("CityName");

        //declaring views in the layout
        ImageView cityimage;
        TextView headingtext, flightsperweektext, daystext,timingtext,onewaypectext,onewayectext,onewaybctext,onewayfctext,returnpectext,returnectext,returnbctext,returnfctext;
        headingtext=(TextView) findViewById(R.id.textView_heading);
        flightsperweektext = (TextView) findViewById(R.id.textView_flightsperweek);
        daystext=(TextView) findViewById(R.id.textView_days);
        timingtext=(TextView) findViewById(R.id.textView_timings);
        onewaypectext=(TextView) findViewById(R.id.textView_oneway_pec);
        onewayectext=(TextView) findViewById(R.id.textView_oneway_ec);
        onewaybctext=(TextView) findViewById(R.id.textView_oneway_bc);
        onewayfctext=(TextView) findViewById(R.id.textView_oneway_fc);
        returnpectext=(TextView) findViewById(R.id.textView_return_pec);
        returnectext=(TextView) findViewById(R.id.textView_return_ec);
        returnbctext=(TextView) findViewById(R.id.textView_return_bc);
        returnfctext=(TextView) findViewById(R.id.textView_return_fc);
        cityimage=(ImageView) findViewById(R.id.imageView_city);

        String heading, flightsperweek, days,timing,onewaypec,onewayec,onewaybc,onewayfc,returnpec,returnec,returnbc,returnfc;

        if(cityname.equals("Faisalabad")){
            cityimage.setImageResource(R.drawable.karachi);
            heading="Flight to "+ cityname;
            flightsperweek="Flights per Week: "+getString(R.string.F_FPW);
            days="Day: "+getString(R.string.F_D);
            timing="Timing: "+getString(R.string.F_T);
            onewaypec=getString(R.string.F_PEC_OW);
            onewayec=getString(R.string.F_EC_OW);
            onewaybc=getString(R.string.F_BC_OW);
            onewayfc=getString(R.string.F_FC_OW);
            returnpec=getString(R.string.F_PEC_R);
            returnec=getString(R.string.F_EC_R);
            returnbc=getString(R.string.F_BC_R);
            returnfc=getString(R.string.F_FC_R);
        }
        else if(cityname.equals("Islamabad")){
            cityimage.setImageResource(R.drawable.karachi);
            heading="Flight to "+ cityname;
            flightsperweek="Flights per Week: "+getString(R.string.I_FPW);
            days="Days: "+getString(R.string.I_D);
            timing="Timing: "+getString(R.string.I_T);
            onewaypec=getString(R.string.I_PEC_OW);
            onewayec=getString(R.string.I_EC_OW);
            onewaybc=getString(R.string.I_BC_OW);
            onewayfc=getString(R.string.I_FC_OW);
            returnpec=getString(R.string.I_PEC_R);
            returnec=getString(R.string.I_EC_R);
            returnbc=getString(R.string.I_BC_R);
            returnfc=getString(R.string.I_FC_R);
        }
        else if(cityname.equals("Karachi")){
            cityimage.setImageResource(R.drawable.karachi);
            heading="Flight to "+ cityname;
            flightsperweek="Flights per Week: "+getString(R.string.K_FPW);
            days="Days: "+getString(R.string.K_D);
            timing="Timing: "+getString(R.string.K_T);
            onewaypec=getString(R.string.K_PEC_OW);
            onewayec=getString(R.string.K_EC_OW);
            onewaybc=getString(R.string.K_BC_OW);
            onewayfc=getString(R.string.K_FC_OW);
            returnpec=getString(R.string.K_PEC_R);
            returnec=getString(R.string.K_EC_R);
            returnbc=getString(R.string.K_BC_R);
            returnfc=getString(R.string.K_FC_R);
        }
        else if(cityname.equals("Lahore")){
            cityimage.setImageResource(R.drawable.karachi);
            heading="Flight to "+ cityname;
            flightsperweek="Flights per Week: "+getString(R.string.L_FPW);
            days="Day: "+getString(R.string.L_D);
            timing="Timing: "+getString(R.string.L_T);
            onewaypec=getString(R.string.L_PEC_OW);
            onewayec=getString(R.string.L_EC_OW);
            onewaybc=getString(R.string.L_BC_OW);
            onewayfc=getString(R.string.L_FC_OW);
            returnpec=getString(R.string.L_PEC_R);
            returnec=getString(R.string.L_EC_R);
            returnbc=getString(R.string.L_BC_R);
            returnfc=getString(R.string.L_FC_R);
        }
        else if(cityname.equals("Peshawar")){
            cityimage.setImageResource(R.drawable.karachi);
            heading="Flight to "+ cityname;
            flightsperweek="Flights per Week: "+getString(R.string.P_FPW);
            days="Day: "+getString(R.string.P_D);
            timing="Timing: "+getString(R.string.P_T);
            onewaypec=getString(R.string.P_PEC_OW);
            onewayec=getString(R.string.P_EC_OW);
            onewaybc=getString(R.string.P_BC_OW);
            onewayfc=getString(R.string.P_FC_OW);
            returnpec=getString(R.string.P_PEC_R);
            returnec=getString(R.string.P_EC_R);
            returnbc=getString(R.string.P_BC_R);
            returnfc=getString(R.string.P_FC_R);
        }
        else{
            heading="";
            flightsperweek="";
            days="";
            timing="";
            onewaypec="";
            onewayec="";
            onewaybc="";
            onewayfc="";
            returnpec="";
            returnec="";
            returnbc="";
            returnfc="";
        }

        headingtext.setText(heading);
        flightsperweektext.setText(flightsperweek);
        daystext.setText(days);
        timingtext.setText(timing);
        onewaypectext.setText(onewaypec);
        onewayectext.setText(onewayec);
        onewaybctext.setText(onewaybc);
        onewayfctext.setText(onewayfc);
        returnpectext.setText(returnpec);
        returnectext.setText(returnec);
        returnbctext.setText(returnbc);
        returnfctext.setText(returnfc);
    }
}
