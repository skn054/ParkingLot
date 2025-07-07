package com.example.service;

import java.time.LocalDateTime;

import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.repository.TicketRepository;

public class TicketService {
    
    private TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    public Ticket generateTicket(Slot slot,String licensePlate){
        Ticket ticket = new Ticket();
        ticket.setLicensePlate(licensePlate);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setStatus(TicketStatus.ACTIVE);
        ticket.setSlotId(slot.getSlotId());
        ticketRepository.save(ticket);
        return ticket;

    }
}
