package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource;

public class VehicleResource {
    private String vehicleModel;
    private int fromConstructionYear;

    private int toConstructionYear;
    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getFromConstructionYear() {
        return fromConstructionYear;
    }

    public void setFromConstructionYear(int fromConstructionYear) {
        this.fromConstructionYear = fromConstructionYear;
    }

    public int getToConstructionYear() {
        return toConstructionYear;
    }

    public void setToConstructionYear(int toConstructionYear) {
        this.toConstructionYear = toConstructionYear;
    }
}
