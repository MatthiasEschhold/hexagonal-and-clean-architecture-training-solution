package de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.interactor;


import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.PartsCatalogView;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.parts.category.CategoryNumber;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.spare.part.SparePart;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.in.LoadPartsCatalogView;
import de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.out.FetchPartCatalogViewQuery;
import de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.out.FetchPartsCatalogView;
import de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.out.LoadSpareParts;

import java.util.List;

public class LoadPartsCatalogViewInteractor implements LoadPartsCatalogView {
    private final FetchPartsCatalogView fetchPartsCatalogView;
    private final LoadSpareParts loadSpareParts;

    public LoadPartsCatalogViewInteractor(FetchPartsCatalogView fetchPartsCatalogView, LoadSpareParts loadSpareParts) {
        this.fetchPartsCatalogView = fetchPartsCatalogView;
        this.loadSpareParts = loadSpareParts;
    }

    @Override
    public PartsCatalogView load(CategoryNumber mainCategory, CategoryNumber subCategory, Vehicle vehicle) {
        PartsCatalogView partsCatalogView = fetchPartsCatalogView.fetch(
                createFetchPartCatalogViewQuery(mainCategory, subCategory, vehicle));
        List<SparePart> spareParts = loadSpareParts.load(partsCatalogView.getConfiguredSparePartNumbers());
        partsCatalogView.addSpareParts(spareParts);
        return partsCatalogView;
    }

    private FetchPartCatalogViewQuery createFetchPartCatalogViewQuery(CategoryNumber mainCategory, CategoryNumber subCategory, Vehicle vehicle) {
        return new FetchPartCatalogViewQuery(mainCategory, subCategory, vehicle.getVehicleConstructionSerie(), vehicle.getConstructionSerieVariant());
    }
}
