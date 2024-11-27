package de.arkem.clean.arc.demo.spare.parts.usecase.interactor;

import de.arkem.clean.arc.demo.spare.parts.domain.model.PartNumber;
public class SparePartNotFoundException extends RuntimeException {
    public SparePartNotFoundException(PartNumber partNumber) {
        super(String.format("SparePart with number: %s not found", partNumber.value()));
    }
}
