package it.bitrock.pubsubdemo.mapper;

import it.bitrock.pubsubdemo.entity.VehicleEntity;
import it.bitrock.pubsubdemo.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public Vehicle mapToVehicle(VehicleEntity vehicleEntity) {
        return new Vehicle(
                vehicleEntity.getId(),
                vehicleEntity.getBrand(),
                vehicleEntity.getModel(),
                vehicleEntity.getColor()
        );
    }

    public VehicleEntity mapToVehicleEntity(Vehicle vehicle) {
        return new VehicleEntity(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getColor());
    }
}
