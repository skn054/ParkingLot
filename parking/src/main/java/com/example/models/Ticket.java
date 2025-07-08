package com.example.models;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket {

    @Id
    private String ticketId;
    private String licensePlate;
     
    private String slotId;      
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amountPaid;
    private TicketStatus status;

    @OneToOne(mappedBy = "ticket")
    private PaymentInvoice paymentInvoice;



    

    


    
    
}
