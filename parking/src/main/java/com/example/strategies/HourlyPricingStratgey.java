package com.example.strategies;

import java.time.Duration;

import com.example.models.Ticket;

public class HourlyPricingStratgey implements PricingStrategy{

    private static final double HOURLY_RATE = 10.0;
    
    @Override
    public double calculatePrice(Ticket ticket) {
        long hours = getEntryTime(ticket);
        return hours * HOURLY_RATE;
    }

    public long getEntryTime(Ticket ticket){
        Duration duration = Duration.between(ticket.getEntryTime(),ticket.getExitTime());
        long hours = duration.toHours();
        return hours;

    }

}
