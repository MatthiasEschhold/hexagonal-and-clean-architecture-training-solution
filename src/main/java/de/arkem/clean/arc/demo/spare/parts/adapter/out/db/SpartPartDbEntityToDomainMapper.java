package de.arkem.clean.arc.demo.spare.parts.adapter.out.db;

import de.arkem.clean.arc.demo.spare.parts.adapter.out.db.entity.SparePartDbEntity;
import de.arkem.clean.arc.demo.spare.parts.domain.model.*;
import de.arkem.shared.domain.object.price.Currency;
import de.arkem.clean.arc.demo.spare.parts.domain.model.PriceConfiguration;
import org.springframework.stereotype.Component;

@Component
public class SpartPartDbEntityToDomainMapper {

    public SparePart mapToDomain(SparePartDbEntity dbEntity) {
        return new SparePart(
            new PartNumber(dbEntity.getPartNumber()),
            new PartName(dbEntity.getPartName()),
            new ManufacturerCode(dbEntity.getManufacturerCode()),
            new PriceConfiguration(
                    new Currency(dbEntity.getPriceConfiguration().getCurrency()),
                    new Price(dbEntity.getPriceConfiguration().getNetPriceRecommodation()),
                    new Price(dbEntity.getPriceConfiguration().getNetPrice())));
    }

}
