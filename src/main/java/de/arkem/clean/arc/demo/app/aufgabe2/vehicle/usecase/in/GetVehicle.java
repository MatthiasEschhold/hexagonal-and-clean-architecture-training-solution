package de.arkem.clean.arc.demo.app.aufgabe2.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vin;

public interface GetVehicle {
    Vehicle get(Vin vin);
}
