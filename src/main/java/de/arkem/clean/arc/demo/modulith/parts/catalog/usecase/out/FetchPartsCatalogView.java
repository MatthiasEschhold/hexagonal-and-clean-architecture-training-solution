package de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.out;

import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.PartsCatalogView;

public interface FetchPartsCatalogView {
    PartsCatalogView fetch(FetchPartCatalogViewQuery fetchPartCatalogViewQuery);
}
