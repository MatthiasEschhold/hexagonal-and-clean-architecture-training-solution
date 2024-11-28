package de.arkem.clean.arc.demo.vehicle.domain.service;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import org.springframework.stereotype.Component;

@Component
public class DetectRegistrationCountryService {

    public CountryCode detect(LicensePlate licensePlate) {
        return new CountryCode("DE");
    }
}
