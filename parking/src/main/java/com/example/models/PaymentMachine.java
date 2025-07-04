package com.example.models;

import com.example.strategies.PaymentProcessor;

public class PaymentMachine {
    private int id;
    private PaymentProcessor paymentProcessor;
    public PaymentMachine(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(Ticket ticket){
        
    }
}
