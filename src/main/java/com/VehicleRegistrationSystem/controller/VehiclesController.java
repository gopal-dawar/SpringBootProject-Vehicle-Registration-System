package com.VehicleRegistrationSystem.controller;

import com.VehicleRegistrationSystem.entity.Vehicles;
import com.VehicleRegistrationSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiclesController {

    @Autowired
    VehicleService vehicleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Vehicles vehicles) {
        return new ResponseEntity<>(vehicleService.addNewVehicles(vehicles), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Vehicles>> viewVehiclesData(@RequestParam String modeloryear) {
        return new ResponseEntity<>(vehicleService.searchByModelYear(modeloryear), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVehicleNumber(@PathVariable int id, @RequestBody Vehicles vehicles) {
        return new ResponseEntity<>(vehicleService.updateVehicleNumber(id, vehicles), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(vehicleService.deleteById(id), HttpStatus.OK);
    }
}
