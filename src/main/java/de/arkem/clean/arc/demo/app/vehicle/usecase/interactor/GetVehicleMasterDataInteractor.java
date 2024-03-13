package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.GetVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FindVehicle;

public class GetVehicleMasterDataInteractor implements GetVehicleMasterData {

    private final FindVehicle findVehicle;

    public GetVehicleMasterDataInteractor(FindVehicle findVehicle) {
        this.findVehicle = findVehicle;
    }

    @Override
    public VehicleMasterData getVehicleMasterData(Vin vin) {
        return findVehicle.findByVin(vin).getVehicleMasterData();
    }
}
