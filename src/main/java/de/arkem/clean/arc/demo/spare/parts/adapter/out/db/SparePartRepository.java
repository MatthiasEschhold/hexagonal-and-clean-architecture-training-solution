package de.arkem.clean.arc.demo.spare.parts.adapter.out.db;

import de.arkem.clean.arc.demo.spare.parts.domain.model.PartNumber;
import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.out.FindSparePart;
import de.arkem.clean.arc.demo.spare.parts.usecase.out.SaveSparePart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SparePartRepository implements SaveSparePart, FindSparePart {

    private final SparePartJpaRepository jpaRepository;
    private final SpartPartDbEntityToDomainMapper mapper;

    public SparePartRepository(SparePartJpaRepository jpaRepository, SpartPartDbEntityToDomainMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<SparePart> findBySparePartNumber(PartNumber partNumber) {
        return Optional.empty();
    }

    @Override
    public List<SparePart> findBySparePartNumbers(List<PartNumber> partNumbers) {
        return null;
    }

    @Override
    public SparePart save(SparePart sparePart) {
        return null;
    }
}
