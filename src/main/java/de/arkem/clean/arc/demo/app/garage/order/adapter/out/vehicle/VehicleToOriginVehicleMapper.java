package de.arkem.clean.arc.demo.app.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.Mileage;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

public class VehicleToOriginVehicleMapper {
    Vehicle mapOriginVehicleToVehicle(de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle vehicle) {
        return new Vehicle(new LicensePlate(vehicle.getLicensePlate().value()),
                new Mileage(vehicle.getMileageRecords().get(0).mileage().value()));
    }
}
