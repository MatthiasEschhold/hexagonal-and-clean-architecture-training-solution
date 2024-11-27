package de.arkem.clean.arc.demo.spare.parts.usecase.in;

import de.arkem.clean.arc.demo.spare.parts.domain.model.PartNumber;
import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;

import java.util.List;

public interface ReadSparePart {
    SparePart read(PartNumber partNumber);
    List<SparePart> readList(List<PartNumber> partNumbers);
}
