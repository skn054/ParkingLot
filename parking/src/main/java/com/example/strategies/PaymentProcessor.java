package com.example.strategies;

import com.example.models.Ticket;

public interface PaymentProcessor {

    public void pay(Ticket ticket, PricingStrategy strategy);
    
}
