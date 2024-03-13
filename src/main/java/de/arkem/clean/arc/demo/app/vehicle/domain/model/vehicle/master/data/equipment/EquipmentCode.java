package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment;

public record EquipmentCode(String value) {

    private static final String EQUIPMENT_CODE_PATTERN = "^[A-Z]{2}[0-9]{4}$";

    public EquipmentCode {
        validateEquipmentCode(value);
    }

    private void validateEquipmentCode(String value) {
        if (value == null || !value.matches(EQUIPMENT_CODE_PATTERN)) {
            throw new IllegalArgumentException("equipment code is not valid");
        }
    }

}
