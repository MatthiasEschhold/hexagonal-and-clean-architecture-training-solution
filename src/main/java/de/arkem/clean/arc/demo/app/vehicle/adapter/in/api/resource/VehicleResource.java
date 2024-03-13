package de.arkem.clean.arc.demo.app.vehicle.adapter.in.api.resource;

import java.util.List;

public class VehicleResource {
    private String vin;
    private String licensePlate;
    private List<MileageRecordResource> mileageRecords;
    private VehicleMasterDataResource vehicleMasterData;

    public VehicleMasterDataResource getVehicleMasterData() {
        return vehicleMasterData;
    }

    public void setVehicleMasterData(VehicleMasterDataResource vehicleMasterData) {
        this.vehicleMasterData = vehicleMasterData;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<MileageRecordResource> getMileageRecords() {
        return mileageRecords;
    }

    public void setMileageRecords(List<MileageRecordResource> mileageRecords) {
        this.mileageRecords = mileageRecords;
    }
}
