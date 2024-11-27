package de.arkem.clean.arc.demo.vehicle.usecase.out;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;

public interface SaveVehicle {
    Vehicle save(Vehicle vehicle);
}
