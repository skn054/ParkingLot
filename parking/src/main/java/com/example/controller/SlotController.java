package com.example.controller;

import com.example.models.Slot;
import com.example.models.SlotStatus;
import com.example.models.SlotType;
import com.example.models.VehicleType;
import com.example.repository.SlotRespository;

public class SlotController {

    public static Slot searchForASlot(VehicleType vehicleType){
            return SlotRespository.getEmptySlot(vehicleType);
    }

    
    public static void freeTheSlot(Slot slot){
        SlotRespository.freeSlot(slot);
    }

    public static void allocateSlot(Slot slot){
            SlotRespository.allocateSlot(slot);
    }

    public void unParkSlotBySlotId(String slotId){
            SlotRepository.unParkSlotBySlotId(slotId);
    }
}
