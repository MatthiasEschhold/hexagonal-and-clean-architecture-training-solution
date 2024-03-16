package de.arkem.clean.arc.demo.modulith.vehicle.domain.service;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheftRiskRatingServiceTest {

    TheftRiskRatingService serviceUnderTest;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new TheftRiskRatingService();
    }

    /**
     * no crossing borders
     * risk country
     */
    @Test
    void detectRiskScoreOf10() {
        CountryOfManufacture countryOfManufacture = new CountryOfManufacture("DE");
        List<CountryCode> riskCountries = List.of(createCountryCountry("DE"),
                createCountryCountry("FR"),
                createCountryCountry("ES"));
        LicensePlate licensePlate = new LicensePlate("ES-EL 0815");
        int riskScore = serviceUnderTest.detectRiskScore(countryOfManufacture, riskCountries, createCountryCountry("DE"));
        assertEquals(10, riskScore);
    }

    /**
     * crossing borders
     * risk country
     */
    @Test
    void detectRiskScoreOf30() {
        CountryOfManufacture countryOfManufacture = new CountryOfManufacture("FR");
        List<CountryCode> riskCountries = List.of(createCountryCountry("DE"),
                createCountryCountry("FR"),
                createCountryCountry("ES"));
        LicensePlate licensePlate = new LicensePlate("ES-EL 0815");
        int riskScore = serviceUnderTest.detectRiskScore(countryOfManufacture, riskCountries, createCountryCountry("DE"));
        assertEquals(30, riskScore);
    }

    /**
     * crossing borders
     * no risk country
     */
    @Test
    void detectRiskScoreOf20() {
        CountryOfManufacture countryOfManufacture = new CountryOfManufacture("US");
        List<CountryCode> riskCountries = List.of(createCountryCountry("FR"),
                createCountryCountry("ES"));
        LicensePlate licensePlate = new LicensePlate("ES-EL 0815");
        int riskScore = serviceUnderTest.detectRiskScore(countryOfManufacture, riskCountries, createCountryCountry("DE"));
        assertEquals(20, riskScore);
    }

    /**
     * no crossing borders
     * no risk country
     */
    @Test
    void detectRiskScoreOf0() {
        CountryOfManufacture countryOfManufacture = new CountryOfManufacture("DE");
        List<CountryCode> riskCountries = List.of(createCountryCountry("US"),
                createCountryCountry("FR"),
                createCountryCountry("ES"));
        LicensePlate licensePlate = new LicensePlate("ES-EL 0815");
        int riskScore = serviceUnderTest.detectRiskScore(countryOfManufacture, riskCountries, createCountryCountry("DE"));
        assertEquals(0, riskScore);
    }

    private CountryCode createCountryCountry(String value) {
        return new CountryCode(value);
    }
}