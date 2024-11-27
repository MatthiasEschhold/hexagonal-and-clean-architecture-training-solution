package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource;

import java.util.List;

public class ExplosionChartResource {
    private String name;
    private CategoryResource mainCategory;
    private CategoryResource subCategory;
    private VehicleResource vehicle;
    private List<SparePartResource> spareParts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryResource getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(CategoryResource mainCategory) {
        this.mainCategory = mainCategory;
    }

    public CategoryResource getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(CategoryResource subCategory) {
        this.subCategory = subCategory;
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
