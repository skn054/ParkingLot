package com.example.strategies;

import com.example.models.Ticket;

public interface PricingStrategy {

    public double calculatePrice(Ticket ticket);

}
