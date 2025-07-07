package com.example.controller;

import com.example.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Slot;
import com.example.models.SlotStatus;
import com.example.models.SlotType;
import com.example.models.Ticket;
import com.example.models.Vehicle;
import com.example.models.VehicleType;
import com.example.repository.SlotRepository;

@RestController
public class SlotController {


    private SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService){
        this.slotService = slotService;
    }
    
    public Slot searchForASlot(Vehicle vehicle){
            Slot slot =  slotService.searchForASlot(vehicle);
            return slot;
    }

    public void UnparkVehicle(String slotId){

        slotService.freeTheSlot(slotId);
    }

    

}
