package it.bitrock.pubsubdemo.service;

import it.bitrock.pubsubdemo.mapper.VehicleMapper;
import it.bitrock.pubsubdemo.model.Vehicle;
import it.bitrock.pubsubdemo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::mapToVehicle).toList();
    }
}
