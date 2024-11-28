@AppModule(
        name = "ExplosionChart",
        allowedDependencies = {"Vehicle", "SpareParts", "SharedModelTypes", "SharedResources"},
        exposedPackages = {
                "..explosion.chart.usecase.in..",
                "..explosion.chart.domain.model.."
        }
)
package de.arkem.clean.arc.demo.explosion.chart;

import de.arkem.shared.domain.model.type.AppModule;

