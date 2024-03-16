package de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.vehicle;

import io.github.domainprimitives.object.ComposedValueObject;

import java.util.List;

public class Vehicle extends ComposedValueObject {
    private final Vin vin;
    private final VehicleConstructionSerie vehicleConstructionSerie;
    private final VehicleConstructionSerieVariant constructionSerieVariant;
    private List<EquipmentCode> equipmentCodes;

    public Vehicle(Vin vin, VehicleConstructionSerie vehicleConstructionSerie, VehicleConstructionSerieVariant constructionSerieVariant, List<EquipmentCode> equipmentCodes) {
        this.vin = vin;
        this.vehicleConstructionSerie = vehicleConstructionSerie;
        this.constructionSerieVariant = constructionSerieVariant;
        this.equipmentCodes = equipmentCodes;
    }

    @Override
    protected void validate() {
        if (vin == null) {
            throw new IllegalArgumentException("vin is not valid");
        }
        if (vehicleConstructionSerie == null) {
            throw new IllegalArgumentException("vehicleConstructionSerie is not valid");
        }
        if (constructionSerieVariant == null) {
            throw new IllegalArgumentException("constructionSerieVariant is not valid");
        }
        if (equipmentCodes == null) {
            throw new IllegalArgumentException("equipmentCodes is not valid");
        }
    }

    public Vin getVin() {
        return vin;
    }

    public VehicleConstructionSerie getVehicleConstructionSerie() {
        return vehicleConstructionSerie;
    }

    public VehicleConstructionSerieVariant getConstructionSerieVariant() {
        return constructionSerieVariant;
    }

    public List<EquipmentCode> getEquipmentCodes() {
        return equipmentCodes;
    }
}
