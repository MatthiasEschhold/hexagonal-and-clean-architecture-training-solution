package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartId;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;

import java.util.List;

public record ExplosionChartResponse(ChartName chartName, ChartId chartId, ExplosionChartVehicle vehicle,
                                     PartsCategory partsCategory, List<SparePartData> spareParts){}


