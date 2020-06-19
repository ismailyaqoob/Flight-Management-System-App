package com.example.flightmanagementsystem;

public class Ticket {
    int id;
    String ticket_number;
    String full_name;
    String address;
    String mobile_number;
    String NIC_number;
    String passport;
    String origin;
    String destination;
    String cabin_class;
    String ticket_type;
    int user_id;

    public Ticket() {
    }

    public Ticket(int id, String ticket_number, String full_name, String address, String mobile_number, String NIC_number, String passport, String origin, String destination, String cabin_class, String ticket_type, int user_id) {
        this.id = id;
        this.ticket_number = ticket_number;
        this.full_name = full_name;
        this.address = address;
        this.mobile_number = mobile_number;
        this.NIC_number = NIC_number;
        this.passport = passport;
        this.origin = origin;
        this.destination = destination;
        this.cabin_class = cabin_class;
        this.ticket_type = ticket_type;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getNIC_number() {
        return NIC_number;
    }

    public String getPassport() {
        return passport;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getCabin_class() {
        return cabin_class;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public int getUser_id() {
        return user_id;
    }
}
