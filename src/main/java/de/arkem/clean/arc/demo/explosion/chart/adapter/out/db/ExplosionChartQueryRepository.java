package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FindExplosionChart;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExplosionChartQueryRepository implements FindExplosionChart {
    private final ExplosionChartJpaRepository explosionChartJpaRepository;
    private final ExplosionChartToDbEntityMapper mapper;

    public ExplosionChartQueryRepository(ExplosionChartJpaRepository explosionChartJpaRepository, ExplosionChartToDbEntityMapper mapper) {
        this.explosionChartJpaRepository = explosionChartJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ExplosionChart> find(CategoryNumber mainCategory, CategoryNumber subCategory, VehicleModel vehicleModel, ConstructionYear constructionYear) {
        return explosionChartJpaRepository.findByMainCategoryAndSubCategoryAndVehicleModelAndConstructionYear(mainCategory.getValue(),
                    subCategory.getValue(), vehicleModel.getValue(), constructionYear.getValue())
                .map(mapper::mapToDomain);
    }
}
