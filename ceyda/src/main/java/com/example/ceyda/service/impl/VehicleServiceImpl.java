package com.example.ceyda.service.impl;

import com.example.ceyda.entity.Vehicle;
import com.example.ceyda.repository.VehicleRepository;
import com.example.ceyda.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public Vehicle findById(Long id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.orElse(null);
    }
}
