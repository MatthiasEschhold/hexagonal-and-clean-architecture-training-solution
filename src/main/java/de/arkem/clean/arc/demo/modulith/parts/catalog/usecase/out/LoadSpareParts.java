package de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.out;

import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.spare.part.SparePart;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.spare.part.SparePartNumber;

import java.util.List;

public interface LoadSpareParts {
    List<SparePart> load(List<SparePartNumber> sparePartNumbers);
}
