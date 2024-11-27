package de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource;

import java.time.LocalDateTime;

public class MileageRecordResource {
    private LocalDateTime recordDate;
    private Double mileage;

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
}
