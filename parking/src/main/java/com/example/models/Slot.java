package com.example.models;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Slot {
     @Id
     private String slotId;
     private SlotType slotType;
     private SlotStatus slotStatus;
     private Vehicle vehicle;
}
