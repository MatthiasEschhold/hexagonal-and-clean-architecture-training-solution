package de.arkem.clean.arc.demo.garage.order.adapter.out.db.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class GarageOrderVehicleDbEntity {
    private String vin;
    private String licensePlate;
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
}
