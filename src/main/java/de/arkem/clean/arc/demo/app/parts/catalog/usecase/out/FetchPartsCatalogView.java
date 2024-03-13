package de.arkem.clean.arc.demo.app.parts.catalog.usecase.out;

import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.PartsCatalogView;

public interface FetchPartsCatalogView {
    PartsCatalogView fetch(FetchPartCatalogViewQuery fetchPartCatalogViewQuery);
}
