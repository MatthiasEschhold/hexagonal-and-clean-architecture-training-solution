package de.arkem.clean.arc.demo.explosion.chart.domain.model;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import io.github.domainprimitives.object.Aggregate;

import java.util.List;

public class ExplosionChart extends Aggregate {
    private final ChartId chartId;
    private final ChartName name;
    private final PartsCategory partsCategory;
    private final ExplosionChartVehicle explosionChartVehicle;
    private final List<SparePartNumber> spareParts;

    public ExplosionChart(ChartId chartId, ChartName name, PartsCategory partsCategory, ExplosionChartVehicle explosionChartVehicle, List<SparePartNumber> spareParts) {
        this.chartId = chartId;
        this.name = name;
        this.partsCategory = partsCategory;
        this.explosionChartVehicle = explosionChartVehicle;
        this.spareParts = spareParts;
        validate();
    }
    @Override
    protected void validate() {
        if (chartId == null || name == null || partsCategory == null || explosionChartVehicle == null || spareParts == null) {
            throw new IllegalArgumentException("Explosion chart could not created due to missing mandatory properties");
        }
    }
    public ChartName getName() {
        return name;
    }

    public PartsCategory getPartsCategory() {
        return partsCategory;
    }
    public ExplosionChartVehicle getVehicle() {
        return explosionChartVehicle;
    }

    public List<SparePartNumber> getSpareParts() {
        return spareParts;
    }
    public ExplosionChartVehicle getExplosionChartVehicle() {
        return explosionChartVehicle;
    }

    public ChartId getChartId() {
        return chartId;
    }

}
