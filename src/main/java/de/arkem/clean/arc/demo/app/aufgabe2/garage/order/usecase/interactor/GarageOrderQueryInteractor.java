package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.interactor;

import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.in.GarageOrderQuery;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderQueryInteractor implements GarageOrderQuery {

    private GarageOrderDbQuery dbQuery;

    public GarageOrderQueryInteractor(GarageOrderDbQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    @Override
    public GarageOrder read(OrderNumber orderNumber) {
        return dbQuery.findByOrderNumber(orderNumber);
    }

}
