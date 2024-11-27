package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.importt;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.in.ImportExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.SaveExplosionChart;
import org.springframework.stereotype.Component;

@Component
public class ImportExplosionChartInteractor implements ImportExplosionChart {

    private final SaveExplosionChart saveExplosionChart;

    public ImportExplosionChartInteractor(SaveExplosionChart saveExplosionChart) {
        this.saveExplosionChart = saveExplosionChart;
    }
    @Override
    public void importt(ImportExplosionChartCommand command) {
        saveExplosionChart.save(new ExplosionChart(command.chartId(), command.chartName(), command.category(),
                command.vehicle(), command.spareParts()));
    }
}
