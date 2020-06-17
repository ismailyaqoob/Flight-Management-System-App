package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void RegisterUser(View v) {
        //declaring views
        EditText fullnametext, emailtext, passwordtext, confirmpasswordtext;
        RadioButton maleradio, femaleradio;

        //initiallizing views
        fullnametext = (EditText) findViewById(R.id.edittext_S_fullname);
        emailtext = (EditText) findViewById(R.id.edittext_S_email);
        passwordtext = (EditText) findViewById(R.id.edittext_S_password);
        confirmpasswordtext = (EditText) findViewById(R.id.edittext_S_confirmpassword);
        maleradio = (RadioButton) findViewById(R.id.radiobutton_S_male);
        femaleradio = (RadioButton) findViewById(R.id.radiobutton_S_female);

        String fullname, email, password, confirmpassword, gender = "";
        fullname = fullnametext.getText().toString();
        email = emailtext.getText().toString();
        password = passwordtext.getText().toString();
        confirmpassword = confirmpasswordtext.getText().toString();

        if (fullname.equals("")) {
            Toast.makeText(this, "Please enter full name.", Toast.LENGTH_LONG).show();
            return;
        }
        if (email.equals("")) {
            Toast.makeText(this, "Please enter email.", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("")) {
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_LONG).show();
            return;
        }
        if (confirmpassword.equals("")) {
            Toast.makeText(this, "Please enter confirm password.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!maleradio.isChecked() && !femaleradio.isChecked()) {
            Toast.makeText(this, "Please select a gender.", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equals(confirmpassword)) {
            Toast.makeText(this, "Password and Confirm password are not same.", Toast.LENGTH_LONG).show();
            return;
        }
        if (maleradio.isChecked()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        Database helper = new Database(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String query="SELECT * FROM USER WHERE EMAIL =\'" + email+"\'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        if (cursor.getCount() > 0) {
            Toast.makeText(this, "Email already exist please change your email address.", Toast.LENGTH_LONG).show();
            cursor.close();
        } else {
            cursor.close();
            ContentValues values = new ContentValues();
            values.put("FULLNAME", fullname);
            values.put("EMAIL", email);
            values.put("PASSWORD", password);
            values.put("GENDER", gender);
            db.insert("USER", null, values);
            Toast.makeText(this, fullname + " your account has been created.", Toast.LENGTH_LONG).show();
            fullnametext.setText("");
            emailtext.setText("");
            passwordtext.setText("");
            confirmpasswordtext.setText("");
            maleradio.setChecked(false);
            femaleradio.setChecked(false);
        }
    }
}
