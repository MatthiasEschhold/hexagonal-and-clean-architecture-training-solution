package de.arkem.clean.arc.demo.explosion.chart.usecase.in;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.ExplosionChartResponse;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.LoadExplosionChartByVinCommand;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.LoadExplosionChartCommand;

public interface LoadExplosionChart {
    ExplosionChartResponse load(LoadExplosionChartCommand command);

    ExplosionChartResponse load(LoadExplosionChartByVinCommand command);
}
