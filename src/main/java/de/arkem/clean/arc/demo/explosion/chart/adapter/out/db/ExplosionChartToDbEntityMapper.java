package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db;

import de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity.CategoryDbEntity;
import de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity.ExplosionChartDbEntity;
import de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity.ExplosionChartSparePartDbEntity;
import de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity.ExplosionChartVehicleDbEntity;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartId;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.SparePartNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.Category;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartToDbEntityMapper {
    public ExplosionChartDbEntity mapToDbEntity(ExplosionChart explosionChart) {
        var explosionChartDbEntity = new ExplosionChartDbEntity();
        explosionChartDbEntity.setMainCategory(mapToCategoryDbEntity(explosionChart.getPartsCategory().getMainCategory()));
        explosionChartDbEntity.setSubCategory(mapToCategoryDbEntity(explosionChart.getPartsCategory().getSubCategory()));
        explosionChartDbEntity.setName(explosionChart.getName().getValue());
        explosionChartDbEntity.setVehicle(mapToVehicle(explosionChart.getVehicle()));
        return explosionChartDbEntity;
    }

    private ExplosionChartVehicleDbEntity mapToVehicle(ExplosionChartVehicle vehicle) {
        var vehicleDbEntity = new ExplosionChartVehicleDbEntity();
        vehicleDbEntity.setModel(vehicle.getModel().getValue());
        vehicleDbEntity.setToConstructionYear(vehicle.getToConstructionYear().getValue());
        vehicleDbEntity.setFromConstructiomYear(vehicle.getFromConstructionYear().getValue());
        return vehicleDbEntity;
    }

    private CategoryDbEntity mapToCategoryDbEntity(Category category) {
        var categoryDbEntity = new CategoryDbEntity();
        categoryDbEntity.setNumber(category.getNumber().getValue());
        categoryDbEntity.setName(category.getName().getValue());
        return categoryDbEntity;
    }

    public ExplosionChart mapToDomain(ExplosionChartDbEntity explosionChartDbEntity) {
        return new ExplosionChart(
                new ChartId(explosionChartDbEntity.getId()),
                new ChartName(explosionChartDbEntity.getName()),
                new PartsCategory(mapToCategory(explosionChartDbEntity.getMainCategory()),
                        mapToCategory(explosionChartDbEntity.getSubCategory())),
                mapToExplosionChartVehicle(explosionChartDbEntity),
                        explosionChartDbEntity.getSpareParts().stream().map(this::mapToSparePartNumber).toList());
    }

    private ExplosionChartVehicle mapToExplosionChartVehicle(ExplosionChartDbEntity explosionChartDbEntity) {
        return new ExplosionChartVehicle(new VehicleModel(explosionChartDbEntity.getVehicle().getModel()),
                new ConstructionYear(explosionChartDbEntity.getVehicle().getFromConstructiomYear()), new ConstructionYear(explosionChartDbEntity.getVehicle().getToConstructionYear()));
    }

    private Category mapToCategory(CategoryDbEntity dbEntity) {
        return new Category(new CategoryName(dbEntity.getName()), new CategoryNumber(dbEntity.getNumber()));
    }
    private SparePartNumber mapToSparePartNumber(ExplosionChartSparePartDbEntity dbEntity) {
        return new SparePartNumber(dbEntity.getSparePartId());
    }

}
