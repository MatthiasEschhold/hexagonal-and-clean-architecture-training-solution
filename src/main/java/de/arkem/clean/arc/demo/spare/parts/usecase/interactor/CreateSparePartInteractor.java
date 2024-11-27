package de.arkem.clean.arc.demo.spare.parts.usecase.interactor;

import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.in.CreateSparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.out.SaveSparePart;
import org.springframework.stereotype.Component;
@Component
public class CreateSparePartInteractor implements CreateSparePart {

    private final SaveSparePart saveSparePart;

    public CreateSparePartInteractor(SaveSparePart saveSparePart) {
        this.saveSparePart = saveSparePart;
    }

    @Override
    public SparePart create(SparePart sparePart) {
        return saveSparePart.save(sparePart);
    }
}
