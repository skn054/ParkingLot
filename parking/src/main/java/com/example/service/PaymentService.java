package com.example.service;

import com.example.models.PaymentInvoice;
import com.example.repository.PaymentRepository;

public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    public void createAndSaveInvoice(PaymentInvoice paymentInvoice){
            paymentRepository.save(paymentInvoice);
    }
    
}
