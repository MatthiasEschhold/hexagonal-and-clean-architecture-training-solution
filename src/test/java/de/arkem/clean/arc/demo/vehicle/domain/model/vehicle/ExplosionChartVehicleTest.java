package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExplosionChartVehicleTest {
    @Test
    void shouldUpdateMileageWithHigherValue() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        vehicle.updateMileage(new Mileage(3000.01));
        assertThat(vehicle.getMileageRecords()).hasSize(4);
    }

    @Test
    void shouldUpdateMileageWithSameValue() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        vehicle.updateMileage(new Mileage(3000.00));
        assertThat(vehicle.getMileageRecords()).hasSize(4);
    }

    @Test
    void shouldThrowExceptionDueToLowerMilegageThanThePrevious() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.updateMileage(new Mileage(2999.99)));
    }

    @Test
    void shouldCreateNewVehicle() {
        Vehicle vehicle = Vehicle.createNewVehicle(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE),
                new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE),
                new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE), VehicleTestDataFactory.createVehicleMasterData());

        assertThat(vehicle.getVin()).isEqualTo(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertThat(vehicle.getLicensePlate()).isEqualTo(new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE));
        assertThat(vehicle.getMileageRecords()).hasSize(1);
        assertThat(vehicle.getMileageRecords().get(0).mileage()).isEqualTo(new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE));
        assertThat(vehicle.getVehicleMasterData().equipmentList()).hasSize(3);
        assertThat(vehicle.getVehicleMasterData().countryOfManufacture()).isEqualTo(new CountryOfManufacture(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE));
    }

    @Test
    void shouldFindLatestMileageWithValue3000withinMultipleItemList() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        assertThat(vehicle.findLatestMileage().isPresent()).isTrue();
        assertThat(vehicle.findLatestMileage().get()).isEqualTo(new Mileage(3000));
    }

    @Test
    void shouldFindLatestMileageWithValue3000withinSingleItemList() {
        Vehicle vehicle = new Vehicle(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE),
                new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE),
                List.of(VehicleTestDataFactory.createMileageRecord(3000, 1)),
                VehicleTestDataFactory.createVehicleMasterData());
        assertThat(vehicle.findLatestMileage().get()).isEqualTo(new Mileage(3000));
    }

}