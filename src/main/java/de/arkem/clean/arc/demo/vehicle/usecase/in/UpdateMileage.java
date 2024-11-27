package de.arkem.clean.arc.demo.vehicle.usecase.in;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;

public interface UpdateMileage {
    Vehicle update(Vin vin, Mileage mileage);
}
