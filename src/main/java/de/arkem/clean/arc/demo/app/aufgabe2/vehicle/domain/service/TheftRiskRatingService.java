package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.risk.rating.RiskCountry;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;


import java.util.List;

public class TheftRiskRatingService {
    public int detectRiskScore(CountryOfManufacture countryOfManufacture, List<RiskCountry> riskCountries, LicensePlate licensePlate) {
        int riskScore = 0;
        String registrationCountry = licensePlate.detectRegistrationCountry();
        if(!countryOfManufacture.value().equals(licensePlate.detectRegistrationCountry())) {
            //grenzübergang
            riskScore += 20;
        }
        if(riskCountries.contains(registrationCountry)) {
            //risikoland
            riskScore += 10;
        }
        return riskScore;
    }
}
