package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class ExplosionChartVehicleToDbEntityMapperTest {

    @Test
    void shouldMapVehicleDomainObjectToVehicleDbEntity() {
        var expectedVehicleDbEntity = VehicleTestDataFactory.constructVehicleDbEntity();
        var vehicle = VehicleTestDataFactory.createVehicle();
        var actualVehicleDbEntity = new VehicleToDbEntityMapper().mapVehicleToDbEntity(vehicle);
        assertThat(actualVehicleDbEntity.getVin(), is(expectedVehicleDbEntity.getVin()));
        assertThat(actualVehicleDbEntity.getMileageRecords(), hasSize(3));
        assertThat(actualVehicleDbEntity.getEquipmentList(), hasSize(3));
        assertThat(actualVehicleDbEntity.getCountryOfManufacture(), is(expectedVehicleDbEntity.getCountryOfManufacture()));
        assertThat(actualVehicleDbEntity.getLicensePlate(), is(expectedVehicleDbEntity.getLicensePlate()));
    }

    @Test
    void mapVehicleDbEntityToEntity() {
        var expectedVehicleDomainObject = VehicleTestDataFactory.createVehicle();
        var vehicleDbEntity = VehicleTestDataFactory.constructVehicleDbEntity();
        var actualVehicleDomainObject = new VehicleToDbEntityMapper().mapVehicleDbEntityToEntity(vehicleDbEntity);
        assertThat(actualVehicleDomainObject.getVin(), is(expectedVehicleDomainObject.getVin()));
        assertThat(actualVehicleDomainObject.getMileageRecords(), hasSize(3));
        assertThat(actualVehicleDomainObject.getVehicleMasterData().equipmentList(), hasSize(3));
        assertThat(actualVehicleDomainObject.getVehicleMasterData().countryOfManufacture(), is(expectedVehicleDomainObject.getVehicleMasterData().countryOfManufacture()));
        assertThat(actualVehicleDomainObject.getLicensePlate(), is(expectedVehicleDomainObject.getLicensePlate()));
    }
}