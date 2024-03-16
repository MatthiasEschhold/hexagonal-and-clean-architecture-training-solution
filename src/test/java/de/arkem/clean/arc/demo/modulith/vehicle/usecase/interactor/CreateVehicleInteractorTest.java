package de.arkem.clean.arc.demo.modulith.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.risk.rating.TheftStatus;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.modulith.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.out.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateVehicleInteractorTest {
    CreateVehicleInteractor interactorUnderTest;
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
    FetchRiskCountries fetchRiskCountries = Mockito.mock(FetchRiskCountries.class);
    DetectTheftStatus detectTheftStatus = Mockito.mock(DetectTheftStatus.class);
    TheftRiskRatingService theftRiskRatingService = Mockito.mock(TheftRiskRatingService.class);

    DetectRegistrationCountry detectRegistrationCountry = Mockito.mock(DetectRegistrationCountry.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new CreateVehicleInteractor(saveVehicle, fetchVehicleMasterData, fetchRiskCountries,
                detectTheftStatus, theftRiskRatingService, detectRegistrationCountry);
    }

    @Test
    void shouldCreateANewVehicle() {
        var licensePlate = new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var mileage = new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE);
        var vehicleMasterData = VehicleTestDataFactory.createVehicleMasterData();

        var savedVehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(detectRegistrationCountry.detect(any(LicensePlate.class))).thenReturn(new CountryCode("DE"));
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(savedVehicle);
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new CountryCode("DE"), new CountryCode("FR")));
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus("NOT_STOLEN"));

        var vehicle = interactorUnderTest.create(vin, licensePlate, mileage);

        assertThat(vehicle.getVin(), equalTo(vin));
        assertThat(vehicle.getLicensePlate(), equalTo(licensePlate));
    }

    @Test
    void shouldThrowExceptionDueToStolenVehicle() {
        var licensePlate = new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var mileage = new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE);
        var vehicleMasterData = VehicleTestDataFactory.createVehicleMasterData();

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(detectRegistrationCountry.detect(any(LicensePlate.class))).thenReturn(new CountryCode("DE"));
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new CountryCode("DE"), new CountryCode("FR")));
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus("STOLEN"));

        assertDoesNotThrow(() -> interactorUnderTest.create(vin, licensePlate, mileage));
    }
}