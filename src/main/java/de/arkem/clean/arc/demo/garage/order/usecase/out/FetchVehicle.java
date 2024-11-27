package de.arkem.clean.arc.demo.garage.order.usecase.out;

import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.GarageOrderVehicle;

import java.util.Optional;

public interface FetchVehicle {
    Optional<GarageOrderVehicle> fetch(LicensePlate licensePlate);
}
