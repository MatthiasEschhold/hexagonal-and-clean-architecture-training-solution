package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.risk.rating.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vin;

public interface DetectTheftStatus {
    TheftStatus detect(Vin vin);
}
