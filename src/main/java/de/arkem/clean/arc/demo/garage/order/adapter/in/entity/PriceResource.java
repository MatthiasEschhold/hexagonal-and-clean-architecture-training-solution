package de.arkem.clean.arc.demo.garage.order.adapter.in.entity;

public class PriceResource {
    private double priceValue;
    private String currency;

    public double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(double priceValue) {
        this.priceValue = priceValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
