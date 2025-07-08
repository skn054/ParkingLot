package com.example.service;

import com.example.controller.SlotNotFoundException;
import com.example.controller.TicketController;
import com.example.models.Slot;
import com.example.models.SlotStatus;
import com.example.models.SlotType;
import com.example.models.Ticket;
import com.example.models.Vehicle;
import com.example.models.VehicleType;
import com.example.repository.SlotRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SlotService {

    /** search in repository if a slot is available of vehicelType provided */
    
    private SlotRepository slotRepository;

    @Autowired
    public SlotService(SlotRepository slotRepository){
        this.slotRepository = slotRepository;
        
    }
    public Slot findAndReserveSlot(Vehicle vehicle) throws SlotNotFoundException{
        VehicleType vehicleType = vehicle.getType();
        SlotType slotType = getRequiredSlotTypeForVehicleType(vehicleType);
        Optional<Slot> slotOpt = slotRepository.findFirstBySlotTypeAndSlotStatus(slotType, SlotStatus.AVAILABLE);
        if(!slotOpt.isPresent()){
            /// search for a slot with bigger size.
             // get next bigger slot and serach if slot is present. If it is the biggest slot return null.
             if(slotType == SlotType.MEDIUM){
                slotOpt = slotRepository.findFirstBySlotTypeAndSlotStatus(SlotType.LARGE, SlotStatus.AVAILABLE);
                
             }else if(slotType == SlotType.SMALL){
                slotOpt = slotRepository.findFirstBySlotTypeAndSlotStatus(SlotType.MEDIUM, SlotStatus.AVAILABLE).or(()->  slotRepository.findFirstBySlotTypeAndSlotStatus(SlotType.LARGE, SlotStatus.AVAILABLE)

                );
             }

             
            
        }
        
        if(!slotOpt.isPresent()){
                throw new SlotNotFoundException("No suitable spot found for vehicle type: " + vehicleType);

        }
        Slot slot = slotOpt.get();
        slot.setVehicle(vehicle);
        slotRepository.save(slot);
        return slot;
        
    }

    private SlotType getRequiredSlotTypeForVehicleType(VehicleType vehicleType) {
        switch (vehicleType) {
            case SMALL:
                return SlotType.SMALL;
            case MEDIUM:
                return SlotType.MEDIUM;
            case LARGE:
                return SlotType.LARGE;
            default:
                // This is important for handling future vehicle types
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }

    
    public void freeTheSlot(String slotId){
            Optional<Slot> slot =  slotRepository.findById(slotId);
            if(slot.isPresent()){
                Slot slt = slot.get();
                slt.setSlotStatus(SlotStatus.AVAILABLE);
                slt.setVehicle(null);
                slotRepository.save(slt);
            }
    }

}
