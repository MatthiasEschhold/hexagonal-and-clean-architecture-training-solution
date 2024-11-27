package de.arkem.clean.arc.demo.vehicle.adapter.out.risk.country;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchRiskCountries;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class RiskCountryServiceClient implements FetchRiskCountries {
    @Override
    public List<CountryCode> fetch() {
        return List.of(new CountryCode("DE"),
                new CountryCode("FR"),
                new CountryCode("IT"));
    }
}
