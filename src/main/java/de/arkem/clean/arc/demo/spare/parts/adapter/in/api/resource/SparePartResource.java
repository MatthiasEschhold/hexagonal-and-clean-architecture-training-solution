package de.arkem.clean.arc.demo.spare.parts.adapter.in.api.resource;

import de.arkem.shared.resource.PriceConfigurationResource;

public class SparePartResource {
    private String manufactureCode;
    private String partName;
    private String partNumber;
    private PriceConfigurationResource priceConfiguration;

    public String getManufactureCode() {
        return manufactureCode;
    }

    public void setManufactureCode(String manufactureCode) {
        this.manufactureCode = manufactureCode;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public PriceConfigurationResource getPriceConfiguration() {
        return priceConfiguration;
    }

    public void setPriceConfiguration(PriceConfigurationResource priceConfiguration) {
        this.priceConfiguration = priceConfiguration;
    }
}
