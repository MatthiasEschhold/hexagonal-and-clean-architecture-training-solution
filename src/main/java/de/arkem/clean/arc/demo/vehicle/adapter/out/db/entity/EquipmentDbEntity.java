package de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EquipmentDbEntity {
    private String equipmentCode;
    private String equipmentLabel;

    public EquipmentDbEntity() {
    }

    public EquipmentDbEntity(String equipmentCode, String equipmentLabel) {
        this.equipmentCode = equipmentCode;
        this.equipmentLabel = equipmentLabel;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentLabel() {
        return equipmentLabel;
    }

    public void setEquipmentLabel(String equipmentLabel) {
        this.equipmentLabel = equipmentLabel;
    }
}
