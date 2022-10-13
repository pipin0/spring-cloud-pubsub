package it.bitrock.pubsubdemo.controller;

import it.bitrock.pubsubdemo.model.Vehicle;
import it.bitrock.pubsubdemo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("db")
public class DbController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/getAll")
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }
}
