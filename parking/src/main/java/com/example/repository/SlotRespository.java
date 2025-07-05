package com.example.repository;

import com.example.models.Floor;
import com.example.models.Slot;
import com.example.models.SlotStatus;
import com.example.models.VehicleType;

public class SlotRespository {

    public static Slot getEmptySlot(VehicleType vehicleType){
        for(Floor floor: floors){
            if(Slot slot : floor.getSlots()){
                if(slot.getSlotStatus() == SlotStatus.AVAILABLE){
                    slot.setSlotStatus(SlotStatus.FILLED);
                    return slot;
                }
            }
        }

        return null;
    }

    public static freeSlot(Slot slot){
        slot.setSlotStatus(SlotStatus.EMPTY);
    }
    
}
