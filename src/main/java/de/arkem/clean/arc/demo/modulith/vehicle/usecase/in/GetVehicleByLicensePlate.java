package de.arkem.clean.arc.demo.modulith.vehicle.usecase.in;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;

public interface GetVehicleByLicensePlate {
    Vehicle get(LicensePlate licensePlate);

}
