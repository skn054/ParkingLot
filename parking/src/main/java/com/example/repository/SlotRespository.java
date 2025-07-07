package com.example.repository;

import com.example.models.Floor;
import com.example.models.Slot;
import com.example.models.SlotStatus;
import com.example.models.VehicleType;

public class SlotRespository {

    public static Slot getEmptySlot(VehicleType vehicleType){
        for(Floor floor: floors){
            for(Slot slot : floor.getSlots()){
                if(slot.getSlotStatus() == SlotStatus.AVAILABLE){
                    // slot.setSlotStatus(SlotStatus.FILLED);
                    return slot;
                }
            }
        }

        return null;
    }

    public void allocateSlot(Slot slot){
        slot.setSlotStatus(SlotStatus.FILLED);
    }

    public static freeSlot(Slot slot){
        slot.setSlotStatus(SlotStatus.EMPTY);
    }

    public static void unParkSlotBySlotId(String slotId){

         for(Floor floor: floors){
            for(Slot slot : floor.getSlots()){
                if(slot.getSlotId().equals(slotId)){
                    slot.setSlotStatus(SlotStatus.AVAILABLE);
                    
                }
            }
        }
		

}

    
}
