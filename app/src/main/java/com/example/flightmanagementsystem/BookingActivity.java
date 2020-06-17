package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> originadapter, destinationadapter, cabinclassadapter;
    AutoCompleteTextView origin, destination, cabinclass;
    RadioGroup destinationradio;

    int User_ID;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent data=getIntent();
        User_ID=data.getIntExtra("userid",0);
        Toast.makeText(this,"hey user "+User_ID,Toast.LENGTH_LONG).show();

        //initializing Views
        origin = (AutoCompleteTextView) findViewById(R.id.autoComplete_origin);
        destination = (AutoCompleteTextView) findViewById(R.id.autoComplete_destination);
        cabinclass = (AutoCompleteTextView) findViewById(R.id.autoComplete_cabinclass);
        destinationradio = (RadioGroup) findViewById(R.id.radiogroup_destination);


        originadapter = ArrayAdapter.createFromResource(this, R.array.orign, R.layout.support_simple_spinner_dropdown_item);
        origin.setAdapter(originadapter);

        cabinclassadapter = ArrayAdapter.createFromResource(this, R.array.cabinclass, R.layout.support_simple_spinner_dropdown_item);
        cabinclass.setAdapter(cabinclassadapter);

        destinationadapter = ArrayAdapter.createFromResource(this, R.array.L_destination, R.layout.support_simple_spinner_dropdown_item);
        destination.setAdapter(destinationadapter);

        origin.setInputType(InputType.TYPE_NULL);
        cabinclass.setInputType(InputType.TYPE_NULL);
        destination.setInputType(InputType.TYPE_NULL);

        destinationradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                destination.setEnabled(true);
                switch (checkedId) {
                    case R.id.radiobutton_local:
                        destinationadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.L_destination, R.layout.support_simple_spinner_dropdown_item);
                        destination.setAdapter(destinationadapter);
                        break;
                    case R.id.radiobutton_international:
                        destinationadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.I_destination, R.layout.support_simple_spinner_dropdown_item);
                        destination.setAdapter(destinationadapter);
                        break;
                }
            }
        });

        origin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin.showDropDown();
            }
        });

        cabinclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cabinclass.showDropDown();
            }
        });

        destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destination.showDropDown();
            }
        });
    }

}
