package de.arkem.clean.arc.demo.vehicle.domain.service;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheftRiskRatingService {
    public int detectRiskScore(CountryOfManufacture countryOfManufacture, List<CountryCode> riskCountries, CountryCode registrationCountry) {
        int riskScore = 0;
        if (!countryOfManufacture.value().equals(registrationCountry.value())) {
            //grenzübergang
            riskScore += 20;
        }
        if (riskCountries.contains(registrationCountry)) {
            //risikoland
            riskScore += 10;
        }
        return riskScore;
    }
}
