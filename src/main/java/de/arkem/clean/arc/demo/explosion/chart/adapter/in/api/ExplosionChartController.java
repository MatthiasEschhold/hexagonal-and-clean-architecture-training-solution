package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api;

import de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource.ExplosionChartResource;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;
import de.arkem.clean.arc.demo.explosion.chart.usecase.in.LoadExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.LoadExplosionChartCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explosioncharts")
class ExplosionChartController {

    private final ExplosionChartToResourceMapper mapper;
    private final LoadExplosionChart loadExplosionChart;

    public ExplosionChartController(ExplosionChartToResourceMapper mapper, LoadExplosionChart loadExplosionChart) {
        this.mapper = mapper;
        this.loadExplosionChart = loadExplosionChart;
    }

    @GetMapping
    public ResponseEntity<ExplosionChartResource> getExplosionChart(@RequestParam Integer mainCategory,
                                    @RequestParam Integer subCategory, @RequestParam String vehicleModel, @RequestParam Integer constructionYear) {
        var explosionChart = loadExplosionChart.load(createLoadExplosionChartCommand(mainCategory, subCategory, vehicleModel, constructionYear));
        return ResponseEntity.ok(mapper.mapToResource(explosionChart));
    }

    private LoadExplosionChartCommand createLoadExplosionChartCommand(Integer mainCategory, Integer subCategory, String vehicleModel, Integer constructionYear) {
        return new LoadExplosionChartCommand(new CategoryNumber(mainCategory),
                new CategoryNumber(subCategory), new VehicleModel(vehicleModel), new ConstructionYear(constructionYear));
    }
}
