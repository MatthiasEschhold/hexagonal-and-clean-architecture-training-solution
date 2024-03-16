package de.arkem.clean.arc.demo.modulith.garage.order.usecase.out;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.Vehicle;

import java.util.Optional;

public interface FetchVehicle {
    Optional<Vehicle> fetch(LicensePlate licensePlate);
}
