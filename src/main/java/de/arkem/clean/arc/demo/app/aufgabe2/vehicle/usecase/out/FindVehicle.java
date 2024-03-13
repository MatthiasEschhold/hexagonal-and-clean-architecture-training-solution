package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vin;

public interface FindVehicle {
    Vehicle findByVin(Vin vin);
}
