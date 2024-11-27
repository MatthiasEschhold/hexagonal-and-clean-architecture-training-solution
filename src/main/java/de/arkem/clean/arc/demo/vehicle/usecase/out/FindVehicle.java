package de.arkem.clean.arc.demo.vehicle.usecase.out;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;

import java.util.List;
import java.util.Optional;

public interface FindVehicle {
    Optional<Vehicle> findByVin(Vin vin);

    List<Vehicle> findAll();
}
