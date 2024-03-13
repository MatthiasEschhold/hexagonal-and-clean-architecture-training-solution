package de.arkem.clean.arc.demo.app.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.position.OrderPosition;

import java.util.List;

public record UpdateGarageOrderCommand(OrderNumber orderNumber, List<OrderPosition> orderPositions) {

}
