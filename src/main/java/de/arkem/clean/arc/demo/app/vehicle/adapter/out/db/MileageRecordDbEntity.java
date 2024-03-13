package de.arkem.clean.arc.demo.app.vehicle.adapter.out.db;

public class MileageRecordDbEntity {

    private double mileage;
    private String recordTime;

    public MileageRecordDbEntity() {

    }

    public MileageRecordDbEntity(double mileage, String recordTime) {
        this.mileage = mileage;
        this.recordTime = recordTime;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}
