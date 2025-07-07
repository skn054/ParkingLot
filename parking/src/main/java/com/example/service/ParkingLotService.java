package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.SlotNotFoundException;
import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.Vehicle;

@Service
public class ParkingLotService {

    private final SlotService slotService;
    private final TicketService ticketService;
    private final VehicleService vehicleService;

     @Autowired
    public ParkingLotService(SlotService slotService, TicketService ticketService, VehicleService vehicleService) {
        this.slotService = slotService;
        this.ticketService = ticketService;
        this.vehicleService = vehicleService;
    }

    public Ticket parkVehicle(Vehicle vehicle) throws SlotNotFoundException {
        
        Slot reservedSlot = slotService.findAndReserveSlot(vehicle);
        
        
        Ticket ticket= ticketService.generateTicket(reservedSlot, vehicle.getLicensePlate());
        
        
        vehicle.setSlotId(reservedSlot.getSlotId());
        vehicleService.saveVehicle(vehicle); 
        
        return ticket;
    }

    public void UnparkVehicle(String vehicleNumber) {
        
            Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
            if(vehicle!=null && vehicle.getSlotId()!=null){
                slotService.freeTheSlot(vehicle.getSlotId());

                /*** get price of ticket and pay for ticket */
                /** if payment successful update ticket status to exit */
                vehicle.setSlotId(null);
                vehicleService.saveVehicle(vehicle);
            }
            
    }
    
}
