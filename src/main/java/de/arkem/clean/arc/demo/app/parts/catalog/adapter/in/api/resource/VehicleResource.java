package de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource;

import java.util.List;

public class VehicleResource {
    private String vin;
    private String vehicleConstructionSerie;
    private String constructionSerieVariant;
    private List<String> equipmentCodes;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleConstructionSerie() {
        return vehicleConstructionSerie;
    }

    public void setVehicleConstructionSerie(String vehicleConstructionSerie) {
        this.vehicleConstructionSerie = vehicleConstructionSerie;
    }

    public String getConstructionSerieVariant() {
        return constructionSerieVariant;
    }

    public void setConstructionSerieVariant(String constructionSerieVariant) {
        this.constructionSerieVariant = constructionSerieVariant;
    }

    public List<String> getEquipmentCodes() {
        return equipmentCodes;
    }

    public void setEquipmentCodes(List<String> equipmentCodes) {
        this.equipmentCodes = equipmentCodes;
    }
}
