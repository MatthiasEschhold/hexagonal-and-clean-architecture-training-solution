package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;

public record LoadExplosionChartByVinCommand(CategoryNumber mainCategory, CategoryNumber subCategory, String vin) {
}
