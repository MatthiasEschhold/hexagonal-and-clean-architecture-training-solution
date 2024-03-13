package de.arkem.clean.arc.demo.app.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

import java.util.Optional;

public interface FetchVehicle {
    Optional<Vehicle> fetch(LicensePlate licensePlate);
}
