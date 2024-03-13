package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.mileage.record.Mileage;

public interface UpdateMileage {
    void update(Vin vin, Mileage mileage);
}
