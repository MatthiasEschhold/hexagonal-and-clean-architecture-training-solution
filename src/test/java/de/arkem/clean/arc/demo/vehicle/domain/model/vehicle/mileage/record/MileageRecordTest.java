package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record;

import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MileageRecordTest {

    @Test
    void shouldCreateMileageRecord() {
        MileageRecord mileageRecord = VehicleTestDataFactory.createMileageRecord(1000, 1);
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

    @Test
    void shouldCreateMileageRecordWithCurrentDate() {
        Mileage mileage = new Mileage(1500);
        MileageRecord mileageRecord = MileageRecord.createMileageRecord(mileage);
        assertEquals(1500, mileageRecord.mileage().value());
        assertNotNull(mileageRecord.recordDate());
    }

    @Test
    void shouldThrowExceptionWhenCreatingMileageRecordWithNullMileage() {
        assertThrows(IllegalArgumentException.class, () -> MileageRecord.createMileageRecord(null));
    }
}