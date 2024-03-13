package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record;

import de.arkem.clean.arc.demo.app.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MileageRecordTest {

    @Test
    void shouldCreateMileageRecord() {
        MileageRecord mileageRecord = VehicleTestDataFactory.createMileageRecord(1000, 0);
        assertEquals(1000, mileageRecord.mileage().value());
        assertNotNull(mileageRecord.recordDate());
    }

    @Test
    void shouldThrowExceptionWhenMileageIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new MileageRecord(null, new RecordDate(LocalDateTime.now())));
    }

    @Test
    void shouldThrowExceptionWhenRecordDateIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new MileageRecord(new Mileage(1000), null));
    }
}