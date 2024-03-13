package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.risk.rating.RiskCountry;

import java.util.List;

public interface FetchRiskCountries {
    List<RiskCountry> fetch();
}
