package de.arkem.clean.arc.demo.app.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;

public interface GetVehicleByVin {
    Vehicle get(Vin vin);

}
