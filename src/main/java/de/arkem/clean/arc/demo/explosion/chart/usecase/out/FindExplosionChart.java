package de.arkem.clean.arc.demo.explosion.chart.usecase.out;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;

import java.util.Optional;

public interface FindExplosionChart {
    Optional<ExplosionChart> find(CategoryNumber mainCategory, CategoryNumber subCategory, VehicleModel vehicleModel, ConstructionYear constructionYear);
}
