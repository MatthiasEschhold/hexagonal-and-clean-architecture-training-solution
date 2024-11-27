package de.arkem.clean.arc.demo.spare.parts.usecase.out;

import de.arkem.clean.arc.demo.spare.parts.domain.model.PartNumber;
import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;

import java.util.List;
import java.util.Optional;

public interface FindSparePart {
    Optional<SparePart> findBySparePartNumber(PartNumber partNumber);
    List<SparePart> findBySparePartNumbers(List<PartNumber> partNumbers);
}
