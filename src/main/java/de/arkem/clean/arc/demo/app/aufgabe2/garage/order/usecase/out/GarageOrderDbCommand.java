package de.arkem.clean.arc.demo.app.aufgabe2.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.aufgabe2.garage.order.domain.model.GarageOrder;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
}
