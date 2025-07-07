package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.models.ParkingLot;
import com.example.models.Slot;
import com.example.models.Ticket;
import com.example.models.Vehicle;
import com.example.service.ParkingLotService;
import com.example.service.SlotService;
import com.example.service.TicketService;
import com.example.service.VehicleService;

public class ParkingController {
    
    private ParkingLotService parkingLotService;
    
    @Autowired
    private TicketController ticketController;
    @Autowired
    private SlotController slotController;

    @Autowired
    private VehicleService vehicleService;

    public ParkingController(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public Ticket parkVehicle(Vehicle vehicle){
        Slot slot = slotController.searchForASlot(vehicle);
         Ticket ticket= ticketController.createTicket(slot, vehicle.getLicensePlate());
         return ticket;
    }

    public void UnparkVehicle(String vehicleNumber){
            Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
            slotController.UnparkVehicle(vehicle.getSlotId());
    }
}
