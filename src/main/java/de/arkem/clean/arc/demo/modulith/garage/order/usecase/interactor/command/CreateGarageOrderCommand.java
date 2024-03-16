package de.arkem.clean.arc.demo.modulith.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.position.OrderPosition;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.Mileage;

import java.util.List;

public record CreateGarageOrderCommand(List<OrderPosition> orderPositions, LicensePlate licensePlate, Mileage mileage) {
    public CreateGarageOrderCommand(List<OrderPosition> orderPositions, LicensePlate licensePlate) {
        this(orderPositions, licensePlate, null);
    }
}
