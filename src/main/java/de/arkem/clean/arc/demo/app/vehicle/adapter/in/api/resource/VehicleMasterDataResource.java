package de.arkem.clean.arc.demo.app.vehicle.adapter.in.api.resource;

import java.util.List;

public class VehicleMasterDataResource {
    private List<EquipmentResource> equipmentList;
    private String countryOfManufacture;

    public List<EquipmentResource> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResource> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(String countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
    }
}
