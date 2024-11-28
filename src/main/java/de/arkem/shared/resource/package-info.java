@AppModule(
        name = "SharedResources",
        allowedDependencies = {"SharedModelTypes"},
        exposedPackages = {
                "..shared.resource.."
        }
)
package de.arkem.shared.resource;

import de.arkem.shared.domain.model.type.AppModule;

