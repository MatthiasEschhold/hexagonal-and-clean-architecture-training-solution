@AppModule(
        name = "SpareParts",
        allowedDependencies = {"SharedModelTypes", "SharedDomainObjects","SharedResources"},
        exposedPackages = {
                "..spare.parts.usecase.in..",
                "..spare.parts.domain.model.."
        }
)
package de.arkem.clean.arc.demo.spare.parts;

import de.arkem.shared.domain.model.type.AppModule;

