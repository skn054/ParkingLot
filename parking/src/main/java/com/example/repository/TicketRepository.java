package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,String>{
    
}
