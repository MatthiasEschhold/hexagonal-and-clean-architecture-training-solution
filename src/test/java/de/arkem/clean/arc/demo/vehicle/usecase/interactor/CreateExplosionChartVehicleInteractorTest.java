package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.vehicle.domain.model.risk.rating.IsStolen;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.domain.service.DetectRegistrationCountryService;
import de.arkem.clean.arc.demo.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.out.DetectTheftStatus;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchRiskCountries;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.usecase.out.SaveVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateExplosionChartVehicleInteractorTest {
    CreateVehicleInteractor interactorUnderTest;
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
    FetchRiskCountries fetchRiskCountries = Mockito.mock(FetchRiskCountries.class);
    DetectTheftStatus detectTheftStatus = Mockito.mock(DetectTheftStatus.class);
    TheftRiskRatingService theftRiskRatingService = Mockito.mock(TheftRiskRatingService.class);

    DetectRegistrationCountryService detectRegistrationCountry = Mockito.mock(DetectRegistrationCountryService.class);

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

        var savedVehicle = Vehicle.createNewVehicle(vin, licensePlate, mileage, vehicleMasterData);

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(detectRegistrationCountry.detect(any(LicensePlate.class))).thenReturn(new CountryCode("DE"));
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(savedVehicle);
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new CountryCode("DE"), new CountryCode("FR")));
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new IsStolen(false));

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
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new IsStolen(true));

        assertDoesNotThrow(() -> interactorUnderTest.create(vin, licensePlate, mileage));
    }
}