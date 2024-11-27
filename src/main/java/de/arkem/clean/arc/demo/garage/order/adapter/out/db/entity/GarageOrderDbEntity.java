package de.arkem.clean.arc.demo.garage.order.adapter.out.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GarageOrderDbEntity {
    @Id @GeneratedValue
    private Integer id;
    @Embedded
    private GarageOrderVehicleDbEntity vehicle;
    @Embedded
    private PriceDbEntity price;
    @ElementCollection
    private List<GarageOrderItemDbEntity> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GarageOrderVehicleDbEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(GarageOrderVehicleDbEntity vehicle) {
        this.vehicle = vehicle;
    }

    public List<GarageOrderItemDbEntity> getItems() {
        return items;
    }

    public void setItems(List<GarageOrderItemDbEntity> items) {
        this.items = items;
    }

    public PriceDbEntity getPrice() {
        return price;
    }

    public void setPrice(PriceDbEntity price) {
        this.price = price;
    }
}
