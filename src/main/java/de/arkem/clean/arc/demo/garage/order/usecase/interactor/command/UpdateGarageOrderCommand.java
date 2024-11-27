package de.arkem.clean.arc.demo.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.garage.order.domain.model.item.OrderItem;

import java.util.List;

public record UpdateGarageOrderCommand(OrderNumber orderNumber, List<OrderItem> orderItems) {
}
