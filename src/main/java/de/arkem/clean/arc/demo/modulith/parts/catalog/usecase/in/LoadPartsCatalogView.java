package de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.in;

import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.PartsCatalogView;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.parts.category.CategoryNumber;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.vehicle.Vehicle;

public interface LoadPartsCatalogView {
    PartsCatalogView load(CategoryNumber mainCategory, CategoryNumber subCategory, Vehicle vehicle);
}
