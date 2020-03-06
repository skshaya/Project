package com.sms.vehicle_service.service;

import com.sms.vehicle_service.model.Vehicle;

import java.util.Optional;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);
    Optional<Vehicle> findById(Integer id);
    Vehicle updateVehicle(Integer id, Vehicle vehicle);
}
