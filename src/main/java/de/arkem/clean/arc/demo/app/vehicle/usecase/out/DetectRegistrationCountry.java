package de.arkem.clean.arc.demo.app.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;

public interface DetectRegistrationCountry {
    CountryCode detect(LicensePlate licensePlate);
}
