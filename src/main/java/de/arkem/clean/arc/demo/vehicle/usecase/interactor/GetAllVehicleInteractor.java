package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetAllVehicles;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GetAllVehicleInteractor implements GetAllVehicles {

    private final FindVehicle findVehicle;

    public GetAllVehicleInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public List<Vehicle> get() {
        return findVehicle.findAll();
    }
}
