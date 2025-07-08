package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.SlotNotFoundException;
import com.example.factory.PaymentFactory;
import com.example.models.PaymentType;
import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.TicketStatus;
import com.example.models.Vehicle;
import com.example.strategies.PaymentProcessor;
import com.example.strategies.PricingStrategy;

@Service
public class ParkingLotService {

    private final SlotService slotService;
    private final TicketService ticketService;
    private final VehicleService vehicleService;
    private final PricingStrategy pricingStrategy;
    private final PaymentFactory paymentFactory;

     @Autowired
    public ParkingLotService(SlotService slotService, TicketService ticketService, VehicleService vehicleService,PricingStrategy pricingStrategy,PaymentFactory paymentFactory) {
        this.slotService = slotService;
        this.ticketService = ticketService;
        this.vehicleService = vehicleService;
        this.pricingStrategy = pricingStrategy;
        this.paymentFactory = paymentFactory;
    }

    
    public Ticket parkVehicle(Vehicle vehicle) throws SlotNotFoundException {
        
        Slot reservedSlot = slotService.findAndReserveSlot(vehicle);
        
        
        Ticket ticket= ticketService.generateTicket(reservedSlot, vehicle.getLicensePlate());
        
        
        vehicle.setSlot(reservedSlot);
        vehicleService.saveVehicle(vehicle); 
        
        return ticket;
    }

    public void UnparkVehicle(String vehicleNumber) throws Exception {
        
            Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
            if(vehicle!=null && vehicle.getSlot().getSlotId()!=null){
                
                Optional<Ticket> ticketOptional = ticketService.getActiveTicketForLicensePlate(vehicleNumber);
                if(!ticketOptional.isPresent()){
                        throw new Exception("Ticket Not Found");
                }
                Ticket ticket = ticketOptional.get();
                ticket.setExitTime(LocalDateTime.now());
                
                PaymentProcessor paymentProcessor = PaymentFactory.getPaymentMethodByType(PaymentType.UPI);
                paymentProcessor.pay(ticket,pricingStrategy);
                ticket.setStatus(TicketStatus.PAID);
                ticketService.save(ticket);

                slotService.freeTheSlot(vehicle.getSlot().getSlotId());

                vehicle.setSlot(null);
                vehicleService.saveVehicle(vehicle);
            }
            
    }
    
}
