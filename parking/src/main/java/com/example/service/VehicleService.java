package com.example.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.Vehicle;
import com.example.repository.VehicleRepository;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByNumber(String number){
           Optional<Vehicle> vehicle =  vehicleRepository.findByLicensePlate(number);
           if(vehicle.isPresent()){
                return vehicle.get();
           }
           return null;
    }

    public void saveVehicle(Vehicle vehicle) {
       
        vehicleRepository.save(vehicle);
    }
    
}
