package de.arkem.clean.arc.demo.app.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;

import java.util.List;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);

    List<GarageOrder> readAll();
}
