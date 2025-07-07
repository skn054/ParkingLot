package com.example.models;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    @Id
    private String licensePlate;
    private VehicleType type; 
    private String slotId;

     public Vehicle( VehicleType type) {
        this.type = type;
    }
    
}
