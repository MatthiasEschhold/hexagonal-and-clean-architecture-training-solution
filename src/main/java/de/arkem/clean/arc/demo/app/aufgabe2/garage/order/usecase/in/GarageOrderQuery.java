package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.OrderNumber;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);
}
