package de.arkem.clean.arc.demo.explosion.chart.adapter.out.vehicle;

import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.VehicleData;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;

public class VehicleToDtoMapper {
    public VehicleData mapToDomain(Vehicle vehicle) {
        return new VehicleData(vehicle.getVehicleMasterData().vehicleModel().value(),
                vehicle.getVehicleMasterData().constructionYear().value());
    }
}
