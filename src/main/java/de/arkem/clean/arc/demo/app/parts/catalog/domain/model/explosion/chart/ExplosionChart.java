package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.explosion.chart;

import io.github.domainprimitives.object.ComposedValueObject;

public class ExplosionChart extends ComposedValueObject {
    private final ExplosionChartId id;
    private final ExplosionChartName name;
    private final ExplosionChartDescription description;

    public ExplosionChart(ExplosionChartId id, ExplosionChartName name, ExplosionChartDescription description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    protected void validate() {
        if (id == null) {
            throw new IllegalArgumentException("id is not valid");
        }
        if (name == null) {
            throw new IllegalArgumentException("name is not valid");
        }
        if (description == null) {
            throw new IllegalArgumentException("description is not valid");
        }
    }

    public ExplosionChartId getId() {
        return id;
    }

    public ExplosionChartName getName() {
        return name;
    }

    public ExplosionChartDescription getDescription() {
        return description;
    }
}
