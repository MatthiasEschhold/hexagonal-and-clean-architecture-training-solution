package de.arkem.clean.arc.demo.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.LicensePlate;

public record CreateGarageOrderCommand(LicensePlate licensePlate) {
}
