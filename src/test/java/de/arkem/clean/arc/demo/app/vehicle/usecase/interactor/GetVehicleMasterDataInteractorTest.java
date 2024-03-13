package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FindVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

class GetVehicleMasterDataInteractorTest {

    GetVehicleMasterDataInteractor interactorUnderTest;
    FindVehicle findVehicle = Mockito.mock(FindVehicle.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new GetVehicleMasterDataInteractor(findVehicle);
    }

    @Test
    void getVehicleMasterData() {
        when(findVehicle.findByVin(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE)))
                .thenReturn(VehicleTestDataFactory.createVehicle());
        VehicleMasterData masterData = interactorUnderTest.getVehicleMasterData(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertThat(masterData, notNullValue());
        assertThat(masterData.countryOfManufacture().value(), is("DE"));
    }
}