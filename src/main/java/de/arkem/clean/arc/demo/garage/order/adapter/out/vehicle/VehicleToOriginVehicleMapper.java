package de.arkem.clean.arc.demo.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.Mileage;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.GarageOrderVehicle;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.Vin;

class VehicleToOriginVehicleMapper {
    GarageOrderVehicle mapOriginVehicleToVehicle(de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle vehicle) {
        return new GarageOrderVehicle(new LicensePlate(vehicle.getLicensePlate().value()), new Vin(vehicle.getVin().value()),
                new Mileage(vehicle.getMileageRecords().get(0).mileage().value()));
    }
}
