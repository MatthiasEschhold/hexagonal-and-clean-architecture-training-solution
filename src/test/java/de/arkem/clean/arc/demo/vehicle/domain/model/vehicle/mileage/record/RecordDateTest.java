package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecordDateTest {

    @Test
    void testRecordDate() {
        LocalDateTime date = LocalDateTime.now();
        RecordDate recordDate = new RecordDate(date);
        assertEquals(date, recordDate.value());
    }

    @Test
    void testRecordDateNull() {
        assertThrows(IllegalArgumentException.class, () -> new RecordDate(null));
    }

    @Test
    void shouldCreateRecordDateWithNow() {
        RecordDate recordDate = RecordDate.createRecordDateWithNow();
        assertThat(LocalDateTime.now().getDayOfYear()).isEqualTo(recordDate.value().getDayOfYear());
        assertThat(LocalDateTime.now().getMonth()).isEqualTo(recordDate.value().getMonth());
    }

}