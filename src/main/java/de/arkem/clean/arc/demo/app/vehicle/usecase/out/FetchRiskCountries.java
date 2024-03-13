package de.arkem.clean.arc.demo.app.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;

import java.util.List;

public interface FetchRiskCountries {
    List<CountryCode> fetch();
}
