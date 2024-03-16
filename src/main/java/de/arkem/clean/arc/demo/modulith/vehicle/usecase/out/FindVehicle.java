package de.arkem.clean.arc.demo.modulith.vehicle.usecase.out;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;

public interface FindVehicle {
    Vehicle findByVin(Vin vin);
}
