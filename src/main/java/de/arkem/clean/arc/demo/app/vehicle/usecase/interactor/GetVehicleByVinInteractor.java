package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.GetVehicleByVin;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FindVehicle;

public class GetVehicleByVinInteractor implements GetVehicleByVin {

    private final FindVehicle findVehicle;

    public GetVehicleByVinInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public Vehicle get(Vin vin) {
        return findVehicle.findByVin(vin);
    }
}
