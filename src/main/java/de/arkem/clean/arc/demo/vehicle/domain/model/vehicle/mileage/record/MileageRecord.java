package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record;

public record MileageRecord(Mileage mileage, RecordDate recordDate) {
    public MileageRecord {
        validateMileageRecord(mileage, recordDate);
    }

    public static MileageRecord createMileageRecord(Mileage mileage) {
        return new MileageRecord(mileage, RecordDate.createRecordDateWithNow());
    }

    private void validateMileageRecord(Mileage mileage, RecordDate recordDate) {
        if (mileage == null || recordDate == null) {
            throw new IllegalArgumentException("kilometerstand record not valid");
        }
    }
}
