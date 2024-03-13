package de.arkem.clean.arc.demo.app.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.position.OrderPosition;

import java.util.List;

public interface AddOrderPositions {
    void add(OrderNumber orderNumber, List<OrderPosition> orderPositions);
}
