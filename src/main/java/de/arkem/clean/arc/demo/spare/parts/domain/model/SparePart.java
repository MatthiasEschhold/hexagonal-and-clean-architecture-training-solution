package de.arkem.clean.arc.demo.spare.parts.domain.model;

public class SparePart {
    private PartNumber partNumber;
    private PartName partName;
    private ManufacturerCode manufacturerCode;
    private PriceConfiguration priceConfiguration;

    public SparePart(PartNumber partNumber, PartName partName, ManufacturerCode manufacturerCode, PriceConfiguration priceConfiguration) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.manufacturerCode = manufacturerCode;
        this.priceConfiguration = priceConfiguration;
    }
    public PartNumber getPartNumber() {
        return partNumber;
    }

    public PartName getPartName() {
        return partName;
    }

    public ManufacturerCode getManufacturerCode() {
        return manufacturerCode;
    }

    public PriceConfiguration getPriceConfiguration() {
        return priceConfiguration;
    }
}
