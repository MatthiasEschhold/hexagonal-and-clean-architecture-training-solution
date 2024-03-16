package de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource;

public class SparePartResource {

    private String sparePartNumber;
    private String sparePartName;
    private double price;
    private int explosionChartNumber;

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

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getExplosionChartNumber() {
        return explosionChartNumber;
    }
    public void setExplosionChartNumber(int explosionChartNumber) {
        this.explosionChartNumber = explosionChartNumber;
    }
}
