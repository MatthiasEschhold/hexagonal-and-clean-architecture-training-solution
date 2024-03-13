package de.arkem.clean.arc.demo.app.parts.catalog.usecase.out;

import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.parts.category.CategoryNumber;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle.VehicleConstructionSerie;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle.VehicleConstructionSerieVariant;

public record FetchPartCatalogViewQuery(CategoryNumber mainCategoryNumber, CategoryNumber subCategoryNumber,
                                        VehicleConstructionSerie serie, VehicleConstructionSerieVariant variant) {
}