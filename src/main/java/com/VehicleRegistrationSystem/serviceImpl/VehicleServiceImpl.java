package com.VehicleRegistrationSystem.serviceImpl;

import com.VehicleRegistrationSystem.entity.Vehicles;
import com.VehicleRegistrationSystem.repository.VehicleRepository;
import com.VehicleRegistrationSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public String addNewVehicles(Vehicles vehicles) {
        vehicleRepository.save(vehicles);
        return "Successfully Submitted!";
    }

    @Override
    public List<Vehicles> searchByModelYear(String modeloryear) {
        if (modeloryear.matches("^\\d+$")) {
            int registrationYear = Integer.parseInt(modeloryear);
            return vehicleRepository.findByYear(registrationYear);
        } else {
            return vehicleRepository.findByModelNumber(modeloryear);
        }
    }

    @Override
    public String updateVehicleNumber(int id, Vehicles vehicles) {
        Vehicles v = vehicleRepository.findById(id).orElseThrow();
        v.setOwnerName(vehicles.getOwnerName());
        v.setVehicleNumber(vehicles.getVehicleNumber());
        v.setModel(vehicles.getModel());
        v.setRegistrationYear(vehicles.getRegistrationYear());
        vehicleRepository.save(v);
        return "Successfully Updated!";
    }

    @Override
    public String deleteById(int id) {
        Vehicles v = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.delete(v);
        return "Successfully Deleted!";
    }
}
