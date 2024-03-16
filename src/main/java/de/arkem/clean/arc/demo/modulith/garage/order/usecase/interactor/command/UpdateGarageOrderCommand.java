package de.arkem.clean.arc.demo.modulith.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.position.OrderPosition;

import java.util.List;

public record UpdateGarageOrderCommand(OrderNumber orderNumber, List<OrderPosition> orderPositions) {

}
