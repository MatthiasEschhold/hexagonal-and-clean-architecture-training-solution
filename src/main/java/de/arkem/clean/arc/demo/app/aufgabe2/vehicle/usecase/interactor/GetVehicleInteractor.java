package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.in.GetVehicle;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out.FindVehicle;

public class GetVehicleInteractor implements GetVehicle {

    private final FindVehicle findVehicle;

    public GetVehicleInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public Vehicle get(Vin vin) {
        return findVehicle.findByVin(vin);
    }
}
