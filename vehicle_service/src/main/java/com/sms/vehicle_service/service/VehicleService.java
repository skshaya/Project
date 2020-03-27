package com.sms.vehicle_service.service;

import com.sms.vehicle_service.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicle();
    Optional<Vehicle> findById(Integer id);
    Vehicle updateVehicle(Integer id, Vehicle vehicle);
    void deleteVehicle(Integer id);
}
