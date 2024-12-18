package de.arkem.clean.arc.demo.vehicle.usecase.in;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;

/**
 * Zwei Konsumenten:
 * SparePartsService
 * GarageOrder
 */
public interface GetVehicleMasterData {

    VehicleMasterData getVehicleMasterData(Vin vin);

}
