package de.arkem.clean.arc.demo.app.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;

import java.util.List;
import java.util.Optional;

public interface GarageOrderDbQuery {
    Optional<GarageOrder> findByOrderNumber(OrderNumber orderNumber);

    List<GarageOrder> findAll();
}
