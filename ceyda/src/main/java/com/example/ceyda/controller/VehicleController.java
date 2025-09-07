package com.example.ceyda.controller;

import com.example.ceyda.dto.request.VehicleRequest;
import com.example.ceyda.dto.response.VehicleResponse;
import com.example.ceyda.entity.Vehicle;
import com.example.ceyda.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;

    @PostMapping
    public VehicleResponse createVehicle(@RequestBody VehicleRequest vehicleRequest) {
        Vehicle vehicle = modelMapper.map(vehicleRequest, Vehicle.class);
        vehicleService.save(vehicle);

        VehicleResponse vehicleResponse = modelMapper.map(vehicle, VehicleResponse.class);
        vehicleResponse.setMessage("Detaylı bilgi için lütfen ilana tıklayınız.");
        return vehicleResponse;
    }

    @GetMapping("/{id}")
    public VehicleResponse findById(@PathVariable Long id){
        Vehicle vehicle = vehicleService.findById(id);
        VehicleResponse vehicleResponse = modelMapper.map(vehicle, VehicleResponse.class);
        vehicleResponse.setMessage("Sonuçlar:");
        return vehicleResponse;
    }


}
