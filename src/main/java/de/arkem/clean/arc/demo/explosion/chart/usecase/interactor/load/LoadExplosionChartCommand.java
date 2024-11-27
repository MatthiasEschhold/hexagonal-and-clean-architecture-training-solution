package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;

public record LoadExplosionChartCommand(CategoryNumber mainCategory, CategoryNumber subCategory,
                                        VehicleModel vehicleModel, ConstructionYear constructionYear) {
}
