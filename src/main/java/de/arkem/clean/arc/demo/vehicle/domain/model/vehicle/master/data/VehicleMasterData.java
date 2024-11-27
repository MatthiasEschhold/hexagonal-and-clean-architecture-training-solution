package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.Equipment;

import java.util.List;

public record VehicleMasterData(VehicleModel vehicleModel, ConstructionYear constructionYear, CountryOfManufacture countryOfManufacture, List<Equipment> equipmentList) {

    public VehicleMasterData {
        validateVehicleMasterData(countryOfManufacture, equipmentList);
    }

    private void validateVehicleMasterData(CountryOfManufacture countryOfManufacture, List<Equipment> equipmentList) {
        if (vehicleModel == null || constructionYear == null || equipmentList == null || equipmentList.isEmpty() || countryOfManufacture == null) {
            throw new IllegalArgumentException("vehicle master data is not valid");
        }
    }
}
