package de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record;

import java.util.Date;

public record RecordDate(Date value) {
    public RecordDate {
        validateRecordTime(value);
    }

    private void validateRecordTime(Date value) {
        if (value == null) {
            throw new IllegalArgumentException("record time is not valid");
        }
    }
}
