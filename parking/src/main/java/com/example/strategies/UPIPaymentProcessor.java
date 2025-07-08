package com.example.strategies;

import com.example.models.PaymentInvoice;
import com.example.models.PaymentStatus;
import com.example.models.Ticket;
import com.example.service.PaymentService;

public class UPIPaymentProcessor implements PaymentProcessor{
    
    private PaymentService paymentService;

    public UPIPaymentProcessor(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void pay(Ticket ticket, PricingStrategy pricingStrategy){
        
        /** create a invoice for payment */

        PaymentInvoice invoice = new PaymentInvoice();
        double cost = pricingStrategy.calculatePrice(ticket);
        ticket.setAmountPaid(cost);
        invoice.setAmount(cost);
        invoice.setTicket(ticket);
        invoice.setPaymentStatus(PaymentStatus.PAID);
        paymentService.createAndSaveInvoice(invoice);
        

        
    }
    
}
