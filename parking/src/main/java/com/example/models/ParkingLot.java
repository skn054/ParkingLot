package com.example.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.controller.ParkingController;
import com.example.controller.SlotController;
import com.example.controller.SlotNotFoundException;
import com.example.controller.TicketController;
import com.example.service.VehicleService;

@Component
public class ParkingLot {
    private Building building;
    private List<Entry> entries;
    private List<Exit> exits;
   
    @Autowired
    private ParkingController parkingController;

    public Ticket parkVehicle(Vehicle vehicle){
        return parkingController.parkVehicle(vehicle);
         
    }

    public void UnparkVehicle(String vehicleNumber){
            parkingController.UnparkVehicle(vehicleNumber);
    }

    
}
