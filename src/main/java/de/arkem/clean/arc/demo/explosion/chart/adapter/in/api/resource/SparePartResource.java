package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource;

public class SparePartResource {
    private String sparePartNumber;
    private String sparePartName;
    private PriceConfigurationResource priceConfiguration;

    private String manufactureCode;

    public String getSparePartNumber() {
        return sparePartNumber;
    }

    public void setSparePartNumber(String sparePartNumber) {
        this.sparePartNumber = sparePartNumber;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    public PriceConfigurationResource getPriceConfiguration() {
        return priceConfiguration;
    }

    public void setPriceConfiguration(PriceConfigurationResource priceConfiguration) {
        this.priceConfiguration = priceConfiguration;
    }

    public String getManufactureCode() {
        return manufactureCode;
    }

    public void setManufactureCode(String manufactureCode) {
        this.manufactureCode = manufactureCode;
    }
}