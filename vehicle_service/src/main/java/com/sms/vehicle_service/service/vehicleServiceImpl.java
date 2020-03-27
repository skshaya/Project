package com.sms.vehicle_service.service;

import com.sms.vehicle_service.model.Vehicle;
import com.sms.vehicle_service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class vehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles=vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle updateVehicle(Integer id, Vehicle vehicle) {
        Vehicle vehicle1 = vehicleRepository.findById((id)).get();
        vehicle1.setVehicleno(vehicle.getVehicleno());
        vehicle1.setPhone(vehicle.getPhone());
        return vehicleRepository.save(vehicle1);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
