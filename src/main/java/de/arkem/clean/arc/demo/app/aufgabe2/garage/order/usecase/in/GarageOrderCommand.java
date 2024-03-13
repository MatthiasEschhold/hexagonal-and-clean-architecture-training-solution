package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.command.CreateGarageOrderCommand;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.command.UpdateGarageOrderCommand;
import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.GarageOrder;

public interface GarageOrderCommand {
    GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand);

    GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand);
}
