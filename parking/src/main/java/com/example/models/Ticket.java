package com.example.models;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    @Id
    private String ticketId;
    private String licensePlate;
     
    private String slotId;      
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amountPaid;
    private TicketStatus status;


    public long getEntryTime(Ticket ticket){
        Duration duration = Duration.between(entryTime,exitTime);
        long hours = duration.toHours();
        return hours;

    }

    


    
    
}
