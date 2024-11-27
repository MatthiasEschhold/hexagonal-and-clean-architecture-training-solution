package de.arkem.clean.arc.demo.vehicle.adapter.out.risk.country;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.CountryCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RiskCountryServiceClientTest {
    private final RiskCountryServiceClient riskCountryServiceClient = new RiskCountryServiceClient();

    @Test
    void fetchShouldReturnListOfCountryCodes() {
        List<CountryCode> result = riskCountryServiceClient.fetch();
        assertThat(result)
                .extracting(CountryCode::value)
                .containsExactly("DE", "FR", "IT");
    }

    @Test
    void fetchShouldReturnNonEmptyList() {
        List<CountryCode> result = riskCountryServiceClient.fetch();
        assertThat(result).isNotEmpty();
    }

    @Test
    void fetchShouldReturnListWithCorrectSize() {
        List<CountryCode> result = riskCountryServiceClient.fetch();
        assertThat(result).hasSize(3);
    }

}