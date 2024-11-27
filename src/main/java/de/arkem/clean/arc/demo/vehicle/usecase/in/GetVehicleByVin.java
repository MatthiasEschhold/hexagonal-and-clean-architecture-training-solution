package de.arkem.clean.arc.demo.vehicle.usecase.in;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;

public interface GetVehicleByVin {
    Vehicle get(Vin vin);

}
