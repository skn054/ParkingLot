package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer>{

    public Optional<Vehicle> findByLicensePlate(String number);
    
}
