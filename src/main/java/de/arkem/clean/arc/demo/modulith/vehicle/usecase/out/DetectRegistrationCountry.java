package de.arkem.clean.arc.demo.modulith.vehicle.usecase.out;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;

public interface DetectRegistrationCountry {
    CountryCode detect(LicensePlate licensePlate);
}
