package de.arkem.clean.arc.demo.vehicle.usecase.out;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.IsStolen;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;

public interface DetectTheftStatus {
    IsStolen detect(Vin vin);
}
