package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;
import de.arkem.clean.arc.demo.explosion.chart.usecase.in.LoadExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FetchSpareParts;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FindExplosionChart;
import org.springframework.stereotype.Component;

@Component
public class LoadExplosionChartInteractor implements LoadExplosionChart {
    private final FindExplosionChart findExplosionChart;
    private final FetchVehicle fetchVehicle;
    private final FetchSpareParts fetchSpareParts;

    public LoadExplosionChartInteractor(FindExplosionChart findExplosionChart, FetchVehicle fetchVehicle, FetchSpareParts fetchSpareParts) {
        this.findExplosionChart = findExplosionChart;
        this.fetchVehicle = fetchVehicle;
        this.fetchSpareParts = fetchSpareParts;
    }

    @Override
    public ExplosionChartResponse load(LoadExplosionChartCommand command) {
        var explosionChart = loadExplosionChart(command.mainCategory(), command.subCategory(), command.vehicleModel(), command.constructionYear());
        return enrichToExplosionChartResponse(explosionChart);
    }
    @Override
    public ExplosionChartResponse load(LoadExplosionChartByVinCommand command) {
        var vehicle = fetchVehicle.fetch(command.vin());
        var explosionChart = loadExplosionChart(command.mainCategory(), command.subCategory(),
                new VehicleModel(vehicle.model()), new ConstructionYear(vehicle.constructionYear()));
        return enrichToExplosionChartResponse(explosionChart);
    }

    private ExplosionChart loadExplosionChart(CategoryNumber mainCategory, CategoryNumber subCategory, VehicleModel vehicleModel, ConstructionYear constructionYear) {
        return findExplosionChart.find(mainCategory, subCategory, vehicleModel, constructionYear)
                .orElseThrow(() -> new ExplosionChartNotFoundException(mainCategory, subCategory, vehicleModel, constructionYear));
    }

    private ExplosionChartResponse enrichToExplosionChartResponse(ExplosionChart explosionChart) {
        var spareParts = fetchSpareParts.fetch(explosionChart.getSpareParts());
        return new ExplosionChartResponse(explosionChart.getName(), explosionChart.getChartId(), explosionChart.getVehicle(),
                explosionChart.getPartsCategory(), spareParts);
    }
}
