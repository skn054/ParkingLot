package com.example.strategies;

import com.example.models.Ticket;

public class HourlyPricingStratgey implements PricingStrategy{

    private static final double HOURLY_RATE = 10.0;
    public void calculatePrice(Ticket ticket){
        long hours = ticket.getEntryTime(ticket);
        return hours * HOURLY_RATE;

    }

}
