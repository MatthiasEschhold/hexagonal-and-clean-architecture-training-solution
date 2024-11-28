package de.arkem.clean.arc.demo.spare.parts.usecase.interactor;

import de.arkem.clean.arc.demo.spare.parts.domain.model.PartNumber;
import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.in.ReadSparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.out.FindSparePart;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ReadSparePartInteractor implements ReadSparePart {

    private final FindSparePart findSparePart;

    //private SparePartJpaRepository repository;

    public ReadSparePartInteractor(FindSparePart findSparePart) {
        this.findSparePart = findSparePart;
    }

    @Override
    public SparePart read(PartNumber partNumber) {
        return findSparePart.findBySparePartNumber(partNumber).orElseThrow(() -> new SparePartNotFoundException(partNumber));
    }

    @Override
    public List<SparePart> readList(List<PartNumber> partNumbers) {
        return null;
    }
}
