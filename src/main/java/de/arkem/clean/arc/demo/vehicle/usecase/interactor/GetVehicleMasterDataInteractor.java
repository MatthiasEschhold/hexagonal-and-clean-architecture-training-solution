package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.springframework.stereotype.Component;

@Component
class GetVehicleMasterDataInteractor implements GetVehicleMasterData {

    private final FindVehicle findVehicle;

    public GetVehicleMasterDataInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public VehicleMasterData getVehicleMasterData(Vin vin) {
        return findVehicle.findByVin(vin)
                .orElseThrow(() -> new VehicleNotFoundException(vin.value()))
                .getVehicleMasterData();
    }
}
