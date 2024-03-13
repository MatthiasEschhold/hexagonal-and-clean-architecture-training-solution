package de.arkem.clean.arc.demo.app.aufgabe2.vehicle.usecase.in;


import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.LicensePlate;

public interface CreateVehicle {
    Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage);
}
