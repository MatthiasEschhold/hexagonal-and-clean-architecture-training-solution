package de.arkem.clean.arc.demo.garage.order.adapter.in.entity;

public class GarageOrderItemResource {
    private int itemNumber;
    private String itemDescription;
    private double quantity;
    private PriceResource netPrice;
    private PriceResource grossPrice;
    private int executionTime;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public PriceResource getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(PriceResource netPrice) {
        this.netPrice = netPrice;
    }

    public PriceResource getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(PriceResource grossPrice) {
        this.grossPrice = grossPrice;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }
}
