package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.Equipment;

import java.util.List;

public record VehicleMasterData(CountryOfManufacture countryOfManufacture, List<Equipment> equipmentList) {

    public VehicleMasterData {
        validateVehicleMasterData(countryOfManufacture, equipmentList);
    }

    private void validateVehicleMasterData(CountryOfManufacture countryOfManufacture, List<Equipment> equipmentList) {
        if(equipmentList == null || equipmentList.isEmpty() || countryOfManufacture == null) {
            throw new IllegalArgumentException("vehicle master data is not valid");
        }
    }
}
