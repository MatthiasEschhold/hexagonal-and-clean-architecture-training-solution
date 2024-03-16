package de.arkem.clean.arc.demo.modulith.vehicle.usecase.out;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.TheftStatus;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;

public interface DetectTheftStatus {
    TheftStatus detect(Vin vin);
}
