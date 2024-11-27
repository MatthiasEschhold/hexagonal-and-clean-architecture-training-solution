package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.importt;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartId;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.SparePartNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;

import java.util.List;

public record ImportExplosionChartCommand(ChartId chartId, ChartName chartName, PartsCategory category,
                                          ExplosionChartVehicle vehicle, List<SparePartNumber> spareParts){}
