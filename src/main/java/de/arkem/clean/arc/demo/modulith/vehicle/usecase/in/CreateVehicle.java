package de.arkem.clean.arc.demo.modulith.vehicle.usecase.in;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.mileage.record.Mileage;

public interface CreateVehicle {
    Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage);
}
