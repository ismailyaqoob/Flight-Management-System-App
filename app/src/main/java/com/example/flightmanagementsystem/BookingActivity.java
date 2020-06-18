package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> originadapter, destinationIadapter, destinationLadapter, cabinclassadapter;
    AutoCompleteTextView originauto, destinationIauto, destinationLauto, cabinclassauto;
    RadioGroup destinationradio;
    RadioButton localradioB, internationalradioB, onewayradioB, returnradioB;
    TextView fullnametext, addresstext, mobilenumbertext, NICnumbertext, passportnumbertext;

    int User_ID;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent data = getIntent();
        User_ID = data.getIntExtra("userid", 0);
        Toast.makeText(this, "hey user " + User_ID, Toast.LENGTH_LONG).show();

        //Initializing Views.
        originauto = (AutoCompleteTextView) findViewById(R.id.autoComplete_origin);
        destinationLauto = (AutoCompleteTextView) findViewById(R.id.autoComplete_Ldestination);
        destinationIauto = (AutoCompleteTextView) findViewById(R.id.autoComplete_Idestination);
        cabinclassauto = (AutoCompleteTextView) findViewById(R.id.autoComplete_cabinclass);
        destinationradio = (RadioGroup) findViewById(R.id.radiogroup_destination);


        originadapter = ArrayAdapter.createFromResource(this, R.array.orign, R.layout.support_simple_spinner_dropdown_item);
        originauto.setAdapter(originadapter);

        cabinclassadapter = ArrayAdapter.createFromResource(this, R.array.cabinclass, R.layout.support_simple_spinner_dropdown_item);
        cabinclassauto.setAdapter(cabinclassadapter);

        destinationLadapter = ArrayAdapter.createFromResource(this, R.array.L_destination, R.layout.support_simple_spinner_dropdown_item);
        destinationLauto.setAdapter(destinationLadapter);

        destinationIadapter = ArrayAdapter.createFromResource(this, R.array.I_destination, R.layout.support_simple_spinner_dropdown_item);
        destinationIauto.setAdapter(destinationIadapter);

        originauto.setInputType(InputType.TYPE_NULL);
        cabinclassauto.setInputType(InputType.TYPE_NULL);
        destinationLauto.setInputType(InputType.TYPE_NULL);
        destinationIauto.setInputType(InputType.TYPE_NULL);

        destinationradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radiobutton_local:
                        destinationIauto.setEnabled(false);
                        destinationIauto.setText("");
                        destinationIauto.clearFocus();
                        destinationLauto.setEnabled(true);
                        break;
                    case R.id.radiobutton_international:
                        destinationLauto.setEnabled(false);
                        destinationLauto.setText("");
                        destinationLauto.clearFocus();
                        destinationIauto.setEnabled(true);
                        break;
                }
            }
        });

        originauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originauto.showDropDown();
            }
        });

        cabinclassauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cabinclassauto.showDropDown();
            }
        });

        destinationIauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destinationIauto.showDropDown();
            }
        });

        destinationLauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destinationLauto.showDropDown();
            }
        });
    }

    public void BookTicket(View v) {
        //Initializing Views.
        fullnametext = (EditText) findViewById(R.id.edittext_B_fullname);
        addresstext = (EditText) findViewById(R.id.edittext_B_address);
        mobilenumbertext = (EditText) findViewById(R.id.edittext_B_mobilenumber);
        NICnumbertext = (EditText) findViewById(R.id.edittext_B_NICnumber);
        passportnumbertext = (EditText) findViewById(R.id.edittext_B_passportnumber);
        localradioB = (RadioButton) findViewById(R.id.radiobutton_local);
        internationalradioB = (RadioButton) findViewById(R.id.radiobutton_international);
        onewayradioB = (RadioButton) findViewById(R.id.radiobutton_oneway);
        returnradioB = (RadioButton) findViewById(R.id.radiobutton_return);

        String fullname, address, mobilenumber, NICnumber, passportnumber, origin, destination = "", cabinclass, tickettype = "";

        fullname = fullnametext.getText().toString();
        address = addresstext.getText().toString();
        mobilenumber = mobilenumbertext.getText().toString();
        NICnumber = NICnumbertext.getText().toString();
        passportnumber = passportnumbertext.getText().toString();
        origin = originauto.getText().toString();
        cabinclass = cabinclassauto.getText().toString();

        if (fullname.equals("")) {
            Toast.makeText(this, "Please enter full name.", Toast.LENGTH_LONG).show();
            return;
        }
        if (address.equals("")) {
            Toast.makeText(this, "Please enter address.", Toast.LENGTH_LONG).show();
            return;
        }
        if (mobilenumber.equals("")) {
            Toast.makeText(this, "Please enter mobile number.", Toast.LENGTH_LONG).show();
            return;
        }
        if (NICnumber.equals("")) {
            Toast.makeText(this, "Please enter NIC number.", Toast.LENGTH_LONG).show();
            return;
        }
        if (passportnumber.equals("")) {
            Toast.makeText(this, "Please enter passport number.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!localradioB.isChecked() && !internationalradioB.isChecked()) {
            Toast.makeText(this, "Please choose destination type.", Toast.LENGTH_LONG).show();
            return;
        } else {
            if (localradioB.isChecked()) {
                destination = destinationLauto.getText().toString();
            } else if (internationalradioB.isChecked()) {
                destination = destinationIauto.getText().toString();
            }
        }
        if (origin.equals("")) {
            Toast.makeText(this, "Please select origin.", Toast.LENGTH_LONG).show();
            return;
        }
        if (destination.equals("")) {
            Toast.makeText(this, "Please select destination.", Toast.LENGTH_LONG).show();
            return;
        }
        if (cabinclass.equals("")) {
            Toast.makeText(this, "Please select cabin class.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!onewayradioB.isChecked() && !returnradioB.isChecked()) {
            Toast.makeText(this, "Please choose ticket type.", Toast.LENGTH_LONG).show();
            return;
        } else {
            if (onewayradioB.isChecked()) {
                tickettype = onewayradioB.getText().toString();
            } else if (returnradioB.isChecked()) {
                tickettype = returnradioB.getText().toString();
            }
        }
        if (destination.equals(origin)) {
            Toast.makeText(this, "Origin and destination cannot be same.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!origin.equals("Faisalabad") && !origin.equals("Islamabad") && !origin.equals("Karachi") && !origin.equals("Lahore") && !origin.equals("Peshawar")) {
            Toast.makeText(this, "Please select valid origin.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!destination.equals("America") && !destination.equals("China") && !destination.equals("Dubai") && !destination.equals("London")
                && !destination.equals("Saudi Arabia") && !destination.equals("Faisalabad") && !destination.equals("Islamabad")
                && !destination.equals("Karachi") && !destination.equals("Lahore") && !destination.equals("Peshawar")) {
            Toast.makeText(this, "Please select valid destination. =>"+destination, Toast.LENGTH_LONG).show();
            return;
        }
        if (!cabinclass.equals("Premium Economy Class") && !cabinclass.equals("Economy Class") && !cabinclass.equals("Business Class") && !cabinclass.equals("First Class")) {
            Toast.makeText(this, "Please select valid cabin class.", Toast.LENGTH_LONG).show();
            return;
        }

        Database helper = new Database(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("FULLNAME",fullname);
        values.put("ADDRESS",address);
        values.put("MOBILENUMBER",mobilenumber);
        values.put("NIC",NICnumber);
        values.put("PASSPORT",passportnumber);
        values.put("ORIGIN",origin);
        values.put("DESTINATION",destination);
        values.put("CABINCLASS",cabinclass);
        values.put("TICKETTYPE",tickettype);
        values.put("USERID",User_ID);
        long id=db.insert("TICKETDETAIL",null,values);
        String ticketnumber=destination.substring(0,3).toUpperCase()+"-"+id;
        values.put("TICKETNUMBER",ticketnumber);
        db.update("TICKETDETAIL",values,"_id="+id,null);
        Toast.makeText(this,"Your ticket has been booked successfully, go and check details.",Toast.LENGTH_LONG).show();
        originauto.setText("");
        destinationIauto.setText("");
        destinationLauto.setText("");
        cabinclassauto.setText("");
        fullnametext.setText("");
        addresstext.setText("");
        mobilenumbertext.setText("");
        NICnumbertext.setText("");
        passportnumbertext.setText("");
        localradioB.setChecked(false);
        internationalradioB.setChecked(false);
        onewayradioB.setChecked(false);
        returnradioB.setChecked(false);
        destinationLauto.setEnabled(false);
        destinationIauto.setEnabled(false);

    }

}
