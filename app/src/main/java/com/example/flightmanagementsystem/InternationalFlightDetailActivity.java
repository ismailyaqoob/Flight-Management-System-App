package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InternationalFlightDetailActivity extends AppCompatActivity {

    String countryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international_flight_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data=getIntent();
        countryname=data.getStringExtra("CountryName");

        //declaring views in the layout
        ImageView countryimage;
        TextView headingtext, flightsperweektext, daystext,timingtext,onewaypectext,onewayectext,onewaybctext,onewayfctext,returnpectext,returnectext,returnbctext,returnfctext;
        headingtext=(TextView) findViewById(R.id.textView_Iheading);
        flightsperweektext = (TextView) findViewById(R.id.textView_Iflightsperweek);
        daystext=(TextView) findViewById(R.id.textView_Idays);
        timingtext=(TextView) findViewById(R.id.textView_Itimings);
        onewaypectext=(TextView) findViewById(R.id.textView_Ioneway_pec);
        onewayectext=(TextView) findViewById(R.id.textView_Ioneway_ec);
        onewaybctext=(TextView) findViewById(R.id.textView_Ioneway_bc);
        onewayfctext=(TextView) findViewById(R.id.textView_Ioneway_fc);
        returnpectext=(TextView) findViewById(R.id.textView_Ireturn_pec);
        returnectext=(TextView) findViewById(R.id.textView_Ireturn_ec);
        returnbctext=(TextView) findViewById(R.id.textView_Ireturn_bc);
        returnfctext=(TextView) findViewById(R.id.textView_Ireturn_fc);
        countryimage=(ImageView) findViewById(R.id.imageView_country);

        String heading, flightsperweek, days,timing,onewaypec,onewayec,onewaybc,onewayfc,returnpec,returnec,returnbc,returnfc;

        if(countryname.equals("America")){
            countryimage.setImageResource(R.drawable.america);
            heading="Flight to "+ countryname;
            flightsperweek="Flights per Week: "+getString(R.string.IA_FPW);
            days="Day: "+getString(R.string.IA_D);
            timing="Timing: "+getString(R.string.IA_T);
            onewaypec=getString(R.string.IA_PEC_OW);
            onewayec=getString(R.string.IA_EC_OW);
            onewaybc=getString(R.string.IA_BC_OW);
            onewayfc=getString(R.string.IA_FC_OW);
            returnpec=getString(R.string.IA_PEC_R);
            returnec=getString(R.string.IA_EC_R);
            returnbc=getString(R.string.IA_BC_R);
            returnfc=getString(R.string.IA_FC_R);
        }
        else if(countryname.equals("China")){
            countryimage.setImageResource(R.drawable.china);
            heading="Flight to "+ countryname;
            flightsperweek="Flights per Week: "+getString(R.string.IC_FPW);
            days="Day: "+getString(R.string.IC_D);
            timing="Timing: "+getString(R.string.IC_T);
            onewaypec=getString(R.string.IC_PEC_OW);
            onewayec=getString(R.string.IC_EC_OW);
            onewaybc=getString(R.string.IC_BC_OW);
            onewayfc=getString(R.string.IC_FC_OW);
            returnpec=getString(R.string.IC_PEC_R);
            returnec=getString(R.string.IC_EC_R);
            returnbc=getString(R.string.IC_BC_R);
            returnfc=getString(R.string.IC_FC_R);
        }
        else if(countryname.equals("Dubai")){
            countryimage.setImageResource(R.drawable.dubai);
            heading="Flight to "+ countryname;
            flightsperweek="Flights per Week: "+getString(R.string.ID_FPW);
            days="Day: "+getString(R.string.ID_D);
            timing="Timing: "+getString(R.string.ID_T);
            onewaypec=getString(R.string.ID_PEC_OW);
            onewayec=getString(R.string.ID_EC_OW);
            onewaybc=getString(R.string.ID_BC_OW);
            onewayfc=getString(R.string.ID_FC_OW);
            returnpec=getString(R.string.ID_PEC_R);
            returnec=getString(R.string.ID_EC_R);
            returnbc=getString(R.string.ID_BC_R);
            returnfc=getString(R.string.ID_FC_R);
        }
        else if(countryname.equals("London")){
            countryimage.setImageResource(R.drawable.london);
            heading="Flight to "+ countryname;
            flightsperweek="Flights per Week: "+getString(R.string.IL_FPW);
            days="Day: "+getString(R.string.IL_D);
            timing="Timing: "+getString(R.string.IL_T);
            onewaypec=getString(R.string.IL_PEC_OW);
            onewayec=getString(R.string.IL_EC_OW);
            onewaybc=getString(R.string.IL_BC_OW);
            onewayfc=getString(R.string.IL_FC_OW);
            returnpec=getString(R.string.IL_PEC_R);
            returnec=getString(R.string.IL_EC_R);
            returnbc=getString(R.string.IL_BC_R);
            returnfc=getString(R.string.IL_FC_R);
        }
        else if(countryname.equals("Saudi Arabia")){
            countryimage.setImageResource(R.drawable.saudiarabia);
            heading="Flight to "+ countryname;
            flightsperweek="Flights per Week: "+getString(R.string.ISA_FPW);
            days="Day: "+getString(R.string.ISA_D);
            timing="Timing: "+getString(R.string.ISA_T);
            onewaypec=getString(R.string.ISA_PEC_OW);
            onewayec=getString(R.string.ISA_EC_OW);
            onewaybc=getString(R.string.ISA_BC_OW);
            onewayfc=getString(R.string.ISA_FC_OW);
            returnpec=getString(R.string.ISA_PEC_R);
            returnec=getString(R.string.ISA_EC_R);
            returnbc=getString(R.string.ISA_BC_R);
            returnfc=getString(R.string.ISA_FC_R);
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
