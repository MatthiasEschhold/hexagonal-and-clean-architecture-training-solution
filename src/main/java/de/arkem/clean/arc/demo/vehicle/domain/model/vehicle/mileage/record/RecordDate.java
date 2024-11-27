package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record;

import java.time.LocalDateTime;

public record RecordDate(LocalDateTime value) {
    public RecordDate {
        if (value == null) {
            throw new IllegalArgumentException("record time is not valid");
        }
    }

    public static RecordDate createRecordDateWithNow() {
        return new RecordDate(LocalDateTime.now());
    }
}
