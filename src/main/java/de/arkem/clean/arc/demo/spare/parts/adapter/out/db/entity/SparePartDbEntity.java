package de.arkem.clean.arc.demo.spare.parts.adapter.out.db.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "partNumber")})
public class SparePartDbEntity {
    @GeneratedValue @Id
    private long id;
    private String partNumber;
    private String partName;
    private String manufacturerCode;
    @Embedded
    private PriceConfigurationDbEntity priceConfiguration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public PriceConfigurationDbEntity getPriceConfiguration() {
        return priceConfiguration;
    }

    public void setPriceConfiguration(PriceConfigurationDbEntity priceConfiguration) {
        this.priceConfiguration = priceConfiguration;
    }
}
