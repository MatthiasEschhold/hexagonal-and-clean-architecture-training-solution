package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryOfManufactureTest {
    private final static List<String> VALID_COUNTRY_CODES = Arrays.asList(
            "DE",
            "US",
            "FR"
    );
    private final static List<String> INVALID_COUNTRY_CODES = Arrays.asList(
            null,
            "",
            " ",
            "USA"
    );

    @Test
    void shouldCreateValidCountryOfManufactureValueObject() {
        VALID_COUNTRY_CODES.forEach(code -> assertDoesNotThrow(() -> new CountryOfManufacture(code)));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidValue() {
        INVALID_COUNTRY_CODES.forEach(code -> assertThrows(IllegalArgumentException.class, () -> new CountryOfManufacture(code)));
    }

    @Test
    void shouldBeEqual() {
        assertThat(new CountryOfManufacture("DE"), is(equalTo(new CountryOfManufacture("DE"))));
    }
}