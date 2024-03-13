package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.out;


import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.OrderNumber;

public interface GarageOrderDbQuery {
    GarageOrder findByOrderNumber(OrderNumber orderNumber);
}
