package de.arkem.clean.arc.demo.app.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;

import java.util.List;

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
