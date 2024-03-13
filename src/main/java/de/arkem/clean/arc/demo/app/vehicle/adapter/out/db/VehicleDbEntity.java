package de.arkem.clean.arc.demo.app.vehicle.adapter.out.db;

import java.util.List;

public class VehicleDbEntity {

    private String vin;
    private String licensePlate;
    private List<MileageRecordDbEntity> mileageRecords;
    private List<EquipmentDbEntity> equipmentList;

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

    public List<MileageRecordDbEntity> getMileageRecords() {
        return mileageRecords;
    }

    public void setMileageRecords(List<MileageRecordDbEntity> mileageRecords) {
        this.mileageRecords = mileageRecords;
    }

    public List<EquipmentDbEntity> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentDbEntity> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
