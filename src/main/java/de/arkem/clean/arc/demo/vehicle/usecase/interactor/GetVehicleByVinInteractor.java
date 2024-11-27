package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleByVin;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.springframework.stereotype.Component;

@Component
class GetVehicleByVinInteractor implements GetVehicleByVin {
    private final FindVehicle findVehicle;

    public GetVehicleByVinInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public Vehicle get(Vin vin) {
        return findVehicle.findByVin(vin)
                .orElseThrow(() -> new VehicleNotFoundException(vin.value()));
    }
}
