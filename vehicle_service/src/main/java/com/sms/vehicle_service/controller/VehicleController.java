package com.sms.vehicle_service.controller;

import com.sms.vehicle_service.model.Vehicle;
import com.sms.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/services")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "Hi, This is my SMS Project";
    }

    @RequestMapping(value = "/vehicle/save",method = RequestMethod.POST)
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    @RequestMapping(value = "/vehicle/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable("id") int id){
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicle/update/{id}")
    public Vehicle updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(id, vehicle);
    }
}

