package com.example.controller;

import com.example.models.Ticket;
import com.example.models.Vehicle;
import com.example.service.ParkingLotService;


public class ParkingController {
    
    private ParkingLotService parkingLotService;
    

    public ParkingController(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
       
    }

    public Ticket parkVehicle(Vehicle vehicle) throws SlotNotFoundException{
       return parkingLotService.parkVehicle(vehicle);
    }

    public void UnparkVehicle(String vehicleNumber){
            parkingLotService.UnparkVehicle(vehicleNumber);
           
    }
}
