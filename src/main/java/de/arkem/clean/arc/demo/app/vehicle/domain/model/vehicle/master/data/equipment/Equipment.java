package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment;

public record Equipment(
        EquipmentCode equipmentCode, EquipmentLabel equipmentLabel) {

    public Equipment {
        validateEquipment(equipmentCode, equipmentLabel);
    }

    private void validateEquipment(EquipmentCode equipmentCode, EquipmentLabel equipmentLabel) {
        if (equipmentCode == null || equipmentLabel == null) {
            throw new IllegalArgumentException("equipment is not valid");
        }
    }
}
