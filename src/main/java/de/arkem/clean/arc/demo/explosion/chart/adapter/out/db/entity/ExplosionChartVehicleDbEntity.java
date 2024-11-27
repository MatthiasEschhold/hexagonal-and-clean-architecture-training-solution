package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ExplosionChartVehicleDbEntity {
    private String model;
    private Integer fromConstructiomYear;
    private Integer toConstructionYear;

    public String getModel() {
        return model;
    }

    public void setModel(String vehicleModel) {
        this.model = vehicleModel;
    }

    public Integer getFromConstructiomYear() {
        return fromConstructiomYear;
    }

    public void setFromConstructiomYear(Integer fromConstructiomYear) {
        this.fromConstructiomYear = fromConstructiomYear;
    }

    public Integer getToConstructionYear() {
        return toConstructionYear;
    }

    public void setToConstructionYear(Integer toConstructionYear) {
        this.toConstructionYear = toConstructionYear;
    }
}
