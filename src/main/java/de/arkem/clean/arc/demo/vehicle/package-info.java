@AppModule(
        name = "Vehicle",
        allowedDependencies = {"SharedModelTypes"},
        exposedPackages = {
                "..vehicle.usecase.in..",
                "..vehicle.domain.model.."
        }
)
package de.arkem.clean.arc.demo.vehicle;

import de.arkem.shared.domain.model.type.AppModule;

