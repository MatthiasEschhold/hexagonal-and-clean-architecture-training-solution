package de.arkem.clean.arc.demo.explosion.chart.adapter.in.chart.provider;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartId;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.SparePartNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.Category;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.importt.ImportExplosionChartCommand;

import java.util.List;
import java.util.stream.Collectors;

public class ExplosionChartEventMapper {

    public ImportExplosionChartCommand mapToDomain(ExplosionChartCreatedEvent event) {
        var chartId = new ChartId(event.getChartId());
        var chartName = new ChartName(event.getName());
        var partCategory = mapToPartCategory(event);
        var vehicle = mapToExplosionChartVehicle(event);
        return new ImportExplosionChartCommand(chartId, chartName, partCategory, vehicle,
                mapToSparePartNumberList(event));
    }

    private List<SparePartNumber> mapToSparePartNumberList(ExplosionChartCreatedEvent event) {
        return event.getSpareParts().stream().map(n -> new SparePartNumber(n)).collect(Collectors.toList());
    }

    private ExplosionChartVehicle mapToExplosionChartVehicle(ExplosionChartCreatedEvent event) {
        return new ExplosionChartVehicle(new VehicleModel(event.getVehicleModel()),
                new ConstructionYear(event.getConstructionYearFrom()), new ConstructionYear(event.getConstructionYearTo()));
    }

    private PartsCategory mapToPartCategory(ExplosionChartCreatedEvent event) {
        return new PartsCategory(mapToCategory(event.getMainCategoryName(), event.getMainCategory()),
                mapToCategory(event.getSubCategoryName(), event.getSubCategory()));
    }

    private Category mapToCategory(String categoryName, int categoryNumber) {
        return new Category(new CategoryName(categoryName),
                new CategoryNumber(categoryNumber));
    }
}
