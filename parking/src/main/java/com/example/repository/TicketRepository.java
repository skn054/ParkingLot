package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Ticket;
import com.example.models.TicketStatus;

public interface TicketRepository extends JpaRepository<Ticket,String>{
    
    public Optional<Ticket> findByLicensePlateAndStatus(String licensePlate,TicketStatus status);
}
