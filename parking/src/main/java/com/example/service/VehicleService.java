package com.example.service;

import java.util.Optional;

import com.example.models.Vehicle;
import com.example.repository.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByNumber(String number){
           Optional<Vehicle> vehicle =  vehicleRepository.findById(number);
           if(vehicle.isPresent()){
                return vehicle.get();
           }
           return null;
    }
    
}
