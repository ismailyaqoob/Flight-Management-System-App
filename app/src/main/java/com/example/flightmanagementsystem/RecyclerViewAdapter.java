package com.example.flightmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Ticket> data;

    public RecyclerViewAdapter(Context context, List<Ticket> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater Inflator=LayoutInflater.from(context);
        view =Inflator.inflate(R.layout.ticket_view_cancel_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
holder.ticketnumbertext.setText(data.get(position).getTicket_number());
holder.ticketdetailcard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ticketdetail=new Intent();
        ticketdetail.putExtra("ticketnumber",data.get(position).getTicket_number());
        ticketdetail.putExtra("fullname",data.get(position).getFull_name());
        ticketdetail.putExtra("address",data.get(position).getAddress());
        ticketdetail.putExtra("mobilenumber",data.get(position).getMobile_number());
        ticketdetail.putExtra("NICnumber",data.get(position).getNIC_number());
        ticketdetail.putExtra("passportnumber",data.get(position).getPassport());
        ticketdetail.putExtra("origin",data.get(position).getOrigin());
        ticketdetail.putExtra("destination",data.get(position).getDestination());
        ticketdetail.putExtra("cabinclass",data.get(position).getCabin_class());
        ticketdetail.putExtra("tickettype",data.get(position).getTicket_type());
        ticketdetail.setClass(context,TicketDetailActivity.class);
        context.startActivity(ticketdetail);
    }
});
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ticketnumbertext;
        CardView ticketdetailcard;
        ImageButton deletebutton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketnumbertext=(TextView) itemView.findViewById(R.id.textview_VC_ticketnumber);
            ticketdetailcard=(CardView) itemView.findViewById(R.id.cardview_VC_ticketdetail);
            deletebutton =(ImageButton) itemView.findViewById(R.id.button_VC_deletebutton);
        }
    }
}
