package com.example.flightmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewCancelActivity extends AppCompatActivity {

    int user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cancel);

        Intent data=getIntent();
        user_id=data.getIntExtra("userid",0);

        Database helper=new Database(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM TICKETDETAIL WHERE USERID=\'"+user_id+"\'",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            List<Ticket> ticketlist=new ArrayList<>();
            do{
                ticketlist.add(new Ticket(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getInt(11)));
            }while (cursor.moveToNext());

            RecyclerView viewcancelrecycler=(RecyclerView) findViewById(R.id.recyclerview_tickets);
            RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this,ticketlist);
            viewcancelrecycler.setLayoutManager(new GridLayoutManager(this,1));
            viewcancelrecycler.setAdapter(recyclerViewAdapter);
        }
    }
}
