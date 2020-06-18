package com.example.flightmanagementsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class Database extends SQLiteOpenHelper {

    private static final String dbname = "dbFlight";
    private static final int Version = 1;

    public Database(Context context) {
        super(context, dbname, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FULLNAME TEXT NOT NULL," +
                "EMAIL TEXT UNIQUE NOT NULL," +
                "PASSWORD TEXT NOT NULL," +
                "GENDER TEXT NOT NULL)");

        db.execSQL("CREATE TABLE TICKETDETAIL(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TICKETNUMBER TEXT UNIQUE," +
                "FULLNAME TEXT NOT NULL," +
                "ADDRESS TEXT NOT NULL," +
                "MOBILENUMBER TEXT NOT NULL," +
                "NIC TEXT NOT NULL," +
                "PASSPORT TEXT NOT NULL," +
                "ORIGIN TEXT NOT NULL," +
                "DESTINATION TEXT NOT NULL," +
                "CABINCLASS TEXT NOT NULL," +
                "TICKETTYPE TEXT NOT NULL," +
                "USERID INTEGER NOT NULL," +
                "FOREIGN KEY(USERID) REFERENCES USER(_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
