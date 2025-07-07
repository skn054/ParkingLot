package com.example.models;

import com.example.controller.SlotController;
import com.example.controller.SlotNotFoundException;
import com.example.controller.TicketController;

public class ParkingLot {
    private Building building;
    private List<Entry> entries;
    private List<Exit> exits;
   
    public Ticket parkVehicle(Vehicle vehicle) throws SlotNotFoundException{
        SLot slot = SlotController.searchForASlot(vehicle.getType());
        if(slot!=null){
            Ticket ticket = TicketController.generateTicket(slot,vehicle.getLicensePlate());
            if(ticket!=null){
                SlotController.AllocateSlot(slot); // mark slot as filled
            }else{
                throw new Exception("Error while generating ticket");
            }
        }else{
            throw new SlotNotFoundException("Not empty slot found");
        }
    }

    public void UnparkVehicle(String vehicleNumber){
        Ticket ticket= TicketController.getTicketByForVehicle(vehicleNumber);
        SlotController.unParkSlotByVehicleNumber(ticket.getSlotId());


    }

    
}
