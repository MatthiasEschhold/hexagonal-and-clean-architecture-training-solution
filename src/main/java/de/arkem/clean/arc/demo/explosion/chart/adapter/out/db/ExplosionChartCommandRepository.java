package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.SaveExplosionChart;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartCommandRepository implements SaveExplosionChart {

    private final ExplosionChartJpaRepository jpaRepository;
    private final ExplosionChartToDbEntityMapper entityMapper;

    public ExplosionChartCommandRepository(ExplosionChartJpaRepository jpaRepository, ExplosionChartToDbEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public void save(ExplosionChart explosionChart) {
        jpaRepository.save(entityMapper.mapToDbEntity(explosionChart));
    }
}
