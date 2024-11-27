package de.arkem.clean.arc.demo.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class ExplosionChartVehicleToResourceMapperTest {

    VehicleToResourceMapper mapperUnderTest;

    @BeforeEach
    void setUp() {
        mapperUnderTest = new VehicleToResourceMapperImpl();
    }

    @Test
    void shouldMapVehicleToResource() {
        var vehicleDomainObject = VehicleTestDataFactory.createVehicle();
        var expectedVehicleResource = VehicleTestDataFactory.constructVehicleResource();

        var actualVehicleResource = mapperUnderTest.mapVehicleToResource(vehicleDomainObject);

        assertThat(actualVehicleResource.getVin())
                .isEqualTo(expectedVehicleResource.getVin());
        assertThat(actualVehicleResource.getLicensePlate())
                .isEqualTo(expectedVehicleResource.getLicensePlate());
        assertThat(actualVehicleResource.getVehicleMasterData().getCountryOfManufacture())
                .isEqualTo(expectedVehicleResource.getVehicleMasterData().getCountryOfManufacture());

        assertThat(actualVehicleResource.getVehicleMasterData().getEquipmentList())
                .extracting("equipmentCode", "equipmentLabel")
                .contains(
                        tuple(vehicleDomainObject.getVehicleMasterData().equipmentList().get(0).equipmentCode().value(),
                                vehicleDomainObject.getVehicleMasterData().equipmentList().get(0).equipmentLabel().value()),
                        tuple(vehicleDomainObject.getVehicleMasterData().equipmentList().get(1).equipmentCode().value(),
                                vehicleDomainObject.getVehicleMasterData().equipmentList().get(1).equipmentLabel().value()),
                        tuple(vehicleDomainObject.getVehicleMasterData().equipmentList().get(2).equipmentCode().value(),
                                vehicleDomainObject.getVehicleMasterData().equipmentList().get(2).equipmentLabel().value())
                );

        assertThat(actualVehicleResource.getMileageRecords())
                .extracting("mileage", "recordDate")
                .contains(
                        tuple(vehicleDomainObject.getMileageRecords().get(0).mileage().value(),
                                vehicleDomainObject.getMileageRecords().get(0).recordDate().value()),
                        tuple(vehicleDomainObject.getMileageRecords().get(1).mileage().value(),
                                vehicleDomainObject.getMileageRecords().get(1).recordDate().value()),
                        tuple(vehicleDomainObject.getMileageRecords().get(2).mileage().value(),
                                vehicleDomainObject.getMileageRecords().get(2).recordDate().value())
                );
    }
}