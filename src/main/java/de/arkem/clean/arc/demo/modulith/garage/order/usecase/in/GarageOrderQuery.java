package de.arkem.clean.arc.demo.modulith.garage.order.usecase.in;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.OrderNumber;

import java.util.List;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);

    List<GarageOrder> readAll();
}
