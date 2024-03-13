package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EquipmentLabelTest {

    @Test
    void shouldValidEquipmentLabel() {
        String label = "test";
        assertThat(new EquipmentLabel(label).value(), is(equalTo(label)));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentLabel(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueBlankString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentLabel(" "));
    }
}