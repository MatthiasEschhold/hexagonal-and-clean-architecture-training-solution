package de.arkem.clean.arc.demo.garage.order.adapter.out.db.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class PriceDbEntity {
    private double netPice;
    private double grossPrice;
    public double getNetPice() {
        return netPice;
    }

    public void setNetPice(double netPice) {
        this.netPice = netPice;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }
}
