package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.vehicle.Vehicle;

public interface FetchVehicle {
    Vehicle fetch(LicensePlate licensePlate);
}
