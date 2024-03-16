package de.arkem.clean.arc.demo.modulith.garage.order.usecase.interactor.query;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.modulith.garage.order.usecase.in.GarageOrderQuery;
import de.arkem.clean.arc.demo.modulith.garage.order.usecase.out.GarageOrderDbQuery;

import java.util.List;

public class GarageOrderQueryInteractor implements GarageOrderQuery {
    private final GarageOrderDbQuery dbQuery;

    public GarageOrderQueryInteractor(GarageOrderDbQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    @Override
    public GarageOrder read(OrderNumber orderNumber) {
        return dbQuery.findByOrderNumber(orderNumber).orElseThrow(() -> new IllegalArgumentException("garage order not found"));
    }

    @Override
    public List<GarageOrder> readAll() {
        return dbQuery.findAll();
    }
}
