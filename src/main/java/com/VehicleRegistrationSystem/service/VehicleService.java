package com.VehicleRegistrationSystem.service;


import com.VehicleRegistrationSystem.entity.Vehicles;

import java.util.List;

public interface VehicleService {
    String addNewVehicles(Vehicles vehicles);

    List<Vehicles> searchByModelYear(String modeloryear);

    String updateVehicleNumber(int id, Vehicles vehicles);

    String deleteById(int id);
}
