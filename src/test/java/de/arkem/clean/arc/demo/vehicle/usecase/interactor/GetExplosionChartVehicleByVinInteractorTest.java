package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

class GetExplosionChartVehicleByVinInteractorTest {
    GetVehicleByVinInteractor interactorUnderTest;
    FindVehicle findVehicle = Mockito.mock(FindVehicle.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new GetVehicleByVinInteractor(findVehicle);
    }

    @Test
    void shouldGetVehicleById() {
        when(findVehicle.findByVin(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE)))
                .thenReturn(Optional.of(VehicleTestDataFactory.createVehicle()));
        Vehicle vehicle = interactorUnderTest.get(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertThat(vehicle.getVin().value(), is(VehicleTestDataFactory.VIN_TEST_VALUE));
    }
}