package de.arkem.clean.arc.demo.vehicle.usecase.out;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
