package de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ExplosionChartVehicleMasterDataServiceClientTest {
    @Test
    void shouldFetchVehicleMasterDataByVin() {
        var mapper = Mockito.mock(VehicleMasterDataToDtoMapper.class);
        when(mapper.mapVehicleMasterDataToEntity(any(VehicleDataDto.class)))
                .thenReturn(VehicleTestDataFactory.createVehicleMasterData());
        var vehicleMasterData = new VehicleMasterDataServiceClient(mapper).fetch(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertEquals(vehicleMasterData.countryOfManufacture().value(), VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE);
        assertEquals(vehicleMasterData.equipmentList().size(), 3);
    }
}