package com.example.ceyda.service;

import com.example.ceyda.entity.Vehicle;

public interface VehicleService {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(Long id);
}
