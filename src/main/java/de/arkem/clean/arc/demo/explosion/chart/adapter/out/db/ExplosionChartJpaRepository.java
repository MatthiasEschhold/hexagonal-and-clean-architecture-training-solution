package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db;

import de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity.ExplosionChartDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExplosionChartJpaRepository extends JpaRepository<ExplosionChartDbEntity, Integer> {
Optional<ExplosionChartDbEntity> findByMainCategoryAndSubCategoryAndVehicleModelAndConstructionYear(
        Integer mainCategory, Integer subCategory, String vehicleModel, Integer constructionYear);
}
