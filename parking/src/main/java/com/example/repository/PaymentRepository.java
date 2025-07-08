package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.PaymentInvoice;

public interface PaymentRepository extends JpaRepository<PaymentInvoice,Integer>{
    
}
