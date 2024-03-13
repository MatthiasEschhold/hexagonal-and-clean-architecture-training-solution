package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api.resource;

import java.util.Date;

public class MileageRecordResource {
    private String recordDate;
    private Double mileage;

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
}
