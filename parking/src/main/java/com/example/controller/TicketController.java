package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.service.TicketService;
import com.example.models.SlotType;

@RestController
public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public Ticket createTicket(Slot slot,String vehicleNumber){
            return ticketService.generateTicket(slot, vehicleNumber);
    }
    public static void makePayment(Ticket ticket){

    }

}
