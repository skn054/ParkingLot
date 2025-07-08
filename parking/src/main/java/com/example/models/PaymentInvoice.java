package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PaymentInvoice {
    
    @Id
    private int id;
    private double amount;
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "ticketId",referencedColumnName = "ticketId")
    private Ticket ticket;
    
}
