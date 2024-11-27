package de.arkem.clean.arc.demo.spare.parts.adapter.out.db;

import de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource.PriceConfigurationResource;
import de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource.SparePartResource;
import de.arkem.clean.arc.demo.spare.parts.adapter.out.db.entity.SparePartDbEntity;
import de.arkem.clean.arc.demo.spare.parts.domain.model.*;
import de.arkem.shared.domain.object.price.Currency;
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

    public SparePartResource mapToResource(SparePart enitity) {
        var priceConfiguration = mapToPriceConfigurationResource(enitity);

        var sparePartResource = new SparePartResource();
        sparePartResource.setSparePartNumber(enitity.getPartNumber().value());
        sparePartResource.setSparePartName(enitity.getPartName().value());
        sparePartResource.setPriceConfiguration(priceConfiguration);
        sparePartResource.setManufactureCode(enitity.getManufacturerCode().value());

        return sparePartResource;
    }

    private PriceConfigurationResource mapToPriceConfigurationResource(SparePart enitity) {
        var priceConfiguration = new PriceConfigurationResource();
        priceConfiguration.setCurrency(enitity.getPriceConfiguration().getCurrency().getValue());
        priceConfiguration.setNetPrice(enitity.getPriceConfiguration().getConfiguredNetPrice().value());
        priceConfiguration.setNetPriceRecommodation(enitity.getPriceConfiguration().getNetPriceRecommodation().value());
        return priceConfiguration;
    }
}
