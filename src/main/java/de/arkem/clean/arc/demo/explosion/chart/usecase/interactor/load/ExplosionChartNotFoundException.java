package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;

public class ExplosionChartNotFoundException extends RuntimeException {
    public ExplosionChartNotFoundException(CategoryNumber mainCategory, CategoryNumber subCategory, VehicleModel vehicleModel, ConstructionYear constructionYear) {
        super(String.format("ExplosionChart with mainCategory: %s, subCategory: %s, model: %s and construction year: %s not found", mainCategory.getValue(), subCategory.getValue(),
                vehicleModel.getValue(), constructionYear.getValue()));
    }
}
