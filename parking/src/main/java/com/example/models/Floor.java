package com.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Floor {
    private int floorNumber;
    private List<Slot> slots;
}
