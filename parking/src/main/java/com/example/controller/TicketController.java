package com.example.controller;

import java.time.LocalDateTime;

import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.models.SlotType;

public class TicketController {

    public static Ticket generateTicket(Slot slot,String licensePlate){
        Ticket ticket = new Ticket();
        ticket.setLicensePlate(licensePlate);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setStatus(TicketStatus.ACTIVE);
        ticket.setSlotId(slot.getSlotId());
        

    }
    public static void makePayment(Ticket ticket){

    }

}
