package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

class GetExplosionChartVehicleMasterDataInteractorTest {

    GetVehicleMasterDataInteractor interactorUnderTest;
    FindVehicle findVehicle = Mockito.mock(FindVehicle.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new GetVehicleMasterDataInteractor(findVehicle);
    }

    @Test
    void getVehicleMasterData() {
        when(findVehicle.findByVin(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE)))
                .thenReturn(Optional.of(VehicleTestDataFactory.createVehicle()));
        VehicleMasterData masterData = interactorUnderTest.getVehicleMasterData(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertThat(masterData, notNullValue());
        assertThat(masterData.countryOfManufacture().value(), is("DE"));
    }
}