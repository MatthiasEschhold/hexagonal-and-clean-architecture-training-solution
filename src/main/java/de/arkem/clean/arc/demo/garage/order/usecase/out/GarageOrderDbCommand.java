package de.arkem.clean.arc.demo.garage.order.usecase.out;

import de.arkem.clean.arc.demo.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.garage.order.domain.model.item.OrderItem;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
    GarageOrder addOrderItem(OrderItem orderItem);
}
