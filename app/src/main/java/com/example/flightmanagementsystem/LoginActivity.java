package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginUser(View v) {
        //Declaring view.
        EditText emailtext, passwordtext;

        //Initializing view.
        emailtext = (EditText) findViewById(R.id.edittext_L_email);
        passwordtext = (EditText) findViewById(R.id.edittext_L_password);

        //Declaring variables that will contain data in Views.
        String email, password;

        //Assigning view values to those variables.
        email = emailtext.getText().toString();
        password = passwordtext.getText().toString();

        //Check is email or/and password are null.
        if (email.equals("")) {
            Toast.makeText(this, "Please enter email address.", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("")) {
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_LONG).show();
            return;
        }

        //Authenticating user.
        Database helper = new Database(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE EMAIL=\'" + email + "\'", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int D_uid = cursor.getInt(0);
            String D_fullname = cursor.getString(1);
            String D_email = cursor.getString(2);
            String D_password = cursor.getString(3);
            if (password.equals(D_password)) {
                Intent dashboard = new Intent();
                dashboard.setClass(this, MainActivity.class);
                dashboard.putExtra("userid", D_uid);
                startActivity(dashboard);
                emailtext.setText("");
                passwordtext.setText("");
            } else {
                Toast.makeText(this, "The password you entered is incorrect.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "The email you entered does not match any account.", Toast.LENGTH_LONG).show();
        }
    }

    public void GoToSignup(View v) {
        Intent signup = new Intent();
        signup.setClass(this, SignupActivity.class);
        startActivity(signup);
    }
}
