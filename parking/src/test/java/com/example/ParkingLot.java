package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.controller.ParkingController;

import com.example.controller.SlotNotFoundException;
import com.example.models.Building;
import com.example.models.Entry;
import com.example.models.Exit;
import com.example.models.Ticket;
import com.example.models.Vehicle;



public class ParkingLot {
    private Building building;
    private List<Entry> entries;
    private List<Exit> exits;
   
    @Autowired
    private ParkingController parkingController;

    public Ticket parkVehicle(Vehicle vehicle) throws SlotNotFoundException{
        return parkingController.parkVehicle(vehicle);
         
    }

    public void UnparkVehicle(String vehicleNumber){
            parkingController.UnparkVehicle(vehicleNumber);
    }

    
}
