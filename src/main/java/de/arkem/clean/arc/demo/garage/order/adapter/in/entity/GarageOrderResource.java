package de.arkem.clean.arc.demo.garage.order.adapter.in.entity;

import java.util.List;

public class GarageOrderResource {
    private long orderNumber;
    private VehicleResource vehicle;
    private PriceResource netPrice;
    private PriceResource grossPrice;
    private List<GarageOrderItemResource> orderItems;

    private int totalExecutionTime;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public VehicleResource getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleResource vehicle) {
        this.vehicle = vehicle;
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

    public List<GarageOrderItemResource> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<GarageOrderItemResource> orderItems) {
        this.orderItems = orderItems;
    }

    public int getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(int totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }
}
