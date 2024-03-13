package de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.mileage.record;

public record MileageRecord(Mileage mileage, RecordDate recordDate) {
    public MileageRecord {
        validateMileageRecord(mileage, recordDate);
    }

    private void validateMileageRecord(Mileage mileage, RecordDate recordDate) {
        if (mileage == null || recordDate == null) {
            throw new IllegalArgumentException("mileage record not valid");
        }
    }

}