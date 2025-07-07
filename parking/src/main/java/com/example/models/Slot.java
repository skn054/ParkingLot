package com.example.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Slot {
     @Id
     private String slotId;
     private SlotType slotType;
     private SlotStatus slotStatus;

      // This creates a foreign key column named "vehicle_id" in the "slot" table.
    // This column will reference the primary key of the "vehicle" table.
     @OneToOne
     @JoinColumn(name="vehicle_id",referencedColumnName = "id")
     private Vehicle vehicle;
}
