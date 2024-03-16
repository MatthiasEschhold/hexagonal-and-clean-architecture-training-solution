package de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.equipment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EquipmentCodeTest {
    @Test
    void shouldCreateValidEquipmentCode() {
        String code = "AB1234";
        Assertions.assertEquals(code, new EquipmentCode(code).value());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToBlankString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode(" "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode("AAB1234"));
    }

}