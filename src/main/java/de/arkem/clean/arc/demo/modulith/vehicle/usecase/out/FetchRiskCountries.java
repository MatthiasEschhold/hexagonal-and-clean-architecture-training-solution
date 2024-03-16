package de.arkem.clean.arc.demo.modulith.vehicle.usecase.out;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.CountryCode;

import java.util.List;

public interface FetchRiskCountries {
    List<CountryCode> fetch();
}
