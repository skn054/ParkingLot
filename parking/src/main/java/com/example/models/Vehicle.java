package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Vehicle {
    @Id
    private Integer id;
    private String licensePlate;
    private VehicleType type; 

     // This field should be a 'Slot' object, not a String ID, for a true bidirectional link.
    // 'mappedBy' tells JPA: "The mapping for this relationship is already defined
    // by the 'vehicle' field in the Slot class. Don't create a column for me here."
    @OneToOne(mappedBy = "vehicle")
    private Slot slot;

     public Vehicle( VehicleType type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }
    
}
