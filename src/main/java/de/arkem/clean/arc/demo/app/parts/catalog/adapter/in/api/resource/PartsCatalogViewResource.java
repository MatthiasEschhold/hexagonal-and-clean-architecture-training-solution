package de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource;

import java.util.List;

public class PartsCatalogViewResource {
    private ExplosionChartResource explosionChart;
    private VehicleResource vehicle;
    private List<SparePartResource> spareParts;

    public ExplosionChartResource getExplosionChart() {
        return explosionChart;
    }

    public void setExplosionChart(ExplosionChartResource explosionChart) {
        this.explosionChart = explosionChart;
    }

    public VehicleResource getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleResource vehicle) {
        this.vehicle = vehicle;
    }

    public List<SparePartResource> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<SparePartResource> spareParts) {
        this.spareParts = spareParts;
    }
}
