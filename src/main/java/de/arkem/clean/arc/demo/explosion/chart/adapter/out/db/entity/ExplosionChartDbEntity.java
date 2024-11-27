package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ExplosionChartDbEntity {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    @Embedded
    private ExplosionChartVehicleDbEntity vehicle;
    @ElementCollection
    private List<ExplosionChartSparePartDbEntity> spareParts;
    @Embedded
    private CategoryDbEntity mainCategory;
    @Embedded
    private CategoryDbEntity subCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExplosionChartVehicleDbEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(ExplosionChartVehicleDbEntity vehicle) {
        this.vehicle = vehicle;
    }

    public List<ExplosionChartSparePartDbEntity> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<ExplosionChartSparePartDbEntity> spareParts) {
        this.spareParts = spareParts;
    }

    public CategoryDbEntity getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(CategoryDbEntity mainCategory) {
        this.mainCategory = mainCategory;
    }

    public CategoryDbEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(CategoryDbEntity subCategory) {
        this.subCategory = subCategory;
    }
}
