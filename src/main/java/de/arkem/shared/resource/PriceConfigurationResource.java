package de.arkem.shared.resource;

public class PriceConfigurationResource {
    private String currency;
    private double netPrice;
    private double netPriceRecommodation;

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

    public double getNetPriceRecommodation() {
        return netPriceRecommodation;
    }

    public void setNetPriceRecommodation(double netPriceRecommodation) {
        this.netPriceRecommodation = netPriceRecommodation;
    }
}
