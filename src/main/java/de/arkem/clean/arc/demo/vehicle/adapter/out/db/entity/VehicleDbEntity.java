package de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "licensePlate")})
public class VehicleDbEntity {
    @Id
    private String vin;
    private String licensePlate;
    private String vehicleModel;
    private int constructionYear;
    @ElementCollection
    private List<MileageRecordDbEntity> mileageRecords;
    @ElementCollection
    private List<EquipmentDbEntity> equipmentList;
    private String countryOfManufacture;

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(String countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
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

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }
}
