package com.example.models;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Slot {
     private String slotId;
     private SlotType slotType;
     private SlotStatus slotStatus;
}
