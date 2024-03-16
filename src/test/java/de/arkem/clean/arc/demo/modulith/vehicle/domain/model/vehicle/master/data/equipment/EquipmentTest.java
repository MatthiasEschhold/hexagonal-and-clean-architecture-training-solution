package de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.equipment;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EquipmentTest {
    @Test
    void shouldCreateValidEuqipmentValueObject() {
        EquipmentCode code = new EquipmentCode("AB1234");
        EquipmentLabel label = new EquipmentLabel("test");
        Equipment equipment = new Equipment(code, label);
        assertThat(equipment.equipmentCode().value(), is("AB1234"));
        assertThat(equipment.equipmentLabel().value(), is("test"));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullEquipmentCode() {
        assertThrows(IllegalArgumentException.class, () -> new Equipment(null, new EquipmentLabel("test")));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullEquipmentLabel() {
        assertThrows(IllegalArgumentException.class, () -> new Equipment(new EquipmentCode("AB1234"), null));
    }
}