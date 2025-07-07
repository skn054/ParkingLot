package com.example.models;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    @Id
    private Integer id;
    private String licensePlate;
    private VehicleType type; 
    private String slotId;

     public Vehicle( VehicleType type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }
    
}
