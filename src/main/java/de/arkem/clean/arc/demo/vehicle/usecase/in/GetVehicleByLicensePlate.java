package de.arkem.clean.arc.demo.vehicle.usecase.in;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;

public interface GetVehicleByLicensePlate {
    Vehicle get(LicensePlate licensePlate);

}
