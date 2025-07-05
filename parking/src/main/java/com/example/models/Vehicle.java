package com.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String licensePlate;
    private VehicleType type; 

     public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    
}
