@AppModule(
        name = "SharedDomainObjects",
        allowedDependencies = {"SharedModelTypes"},
        exposedPackages = {"..shared.domain.object.."}
)
package de.arkem.shared.domain.object;

import de.arkem.shared.domain.model.type.AppModule;