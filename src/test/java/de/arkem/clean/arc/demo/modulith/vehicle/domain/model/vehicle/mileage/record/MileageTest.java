package de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.mileage.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MileageTest {

    @Test
    void shouldCreateMileage() {
        Mileage mileage = new Mileage(1000);
        assertEquals(1000, mileage.value());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Mileage(-1000));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToZeroValue() {
        assertThrows(IllegalArgumentException.class, () -> new Mileage(0));
    }

    @Test
    void shouldBeEquals() {
        Mileage mileage1 = new Mileage(1000);
        Mileage mileage2 = new Mileage(1000);
        assertEquals(mileage1, mileage2);
    }

    @Test
    void shouldNotBeEquals() {
        Mileage mileage1 = new Mileage(1000);
        Mileage mileage2 = new Mileage(2000);
        assertNotEquals(mileage1, mileage2);
    }

}