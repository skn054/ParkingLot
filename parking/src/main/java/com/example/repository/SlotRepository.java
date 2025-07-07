package com.example.repository;

import com.example.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot,String> {


    Optional<Slot> findFirstBySlotTypeAndSlotStatus(SlotType slotType, SlotStatus slotStatus);


}
