package de.arkem.clean.arc.demo.explosion.chart.adapter.out.db.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class ExplosionChartSparePartDbEntity {
    @Id
    private String sparePartId;
    private String sparePartName;
    private String currency;
    private double netPrice;
    private double priceRecommodation;
    public String getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getPriceRecommodation() {
        return priceRecommodation;
    }

    public void setPriceRecommodation(double priceRecommodation) {
        this.priceRecommodation = priceRecommodation;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }
}
