package de.arkem.clean.arc.demo.spare.parts.adapter.in.api;

import de.arkem.clean.arc.demo.spare.parts.adapter.in.api.resource.SparePartResource;
import de.arkem.clean.arc.demo.spare.parts.domain.model.SparePart;
import de.arkem.shared.resource.PriceConfigurationResource;
import org.springframework.stereotype.Component;

@Component
public class SpartPartResourceToDomainMapper {

    public SparePartResource mapToResource(SparePart enitity) {
        var priceConfiguration = mapToPriceConfigurationResource(enitity);

        var sparePartResource = new SparePartResource();
        sparePartResource.setPartNumber(enitity.getPartNumber().value());
        sparePartResource.setPartName(enitity.getPartName().value());
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
