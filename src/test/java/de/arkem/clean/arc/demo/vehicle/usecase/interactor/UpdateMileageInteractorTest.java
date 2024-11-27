package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.out.SaveVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UpdateMileageInteractorTest {
    private static final String VIN_TEST_VALUE = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EL 0815";
    private static final double MILEAGE_TEST_VALUE = 1000;
    UpdateMileageInteractor updateMileageInteractor;
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FindVehicle findVehicle = Mockito.mock(FindVehicle.class);

    @BeforeEach
    void setUp() {
        updateMileageInteractor = new UpdateMileageInteractor(saveVehicle, findVehicle);
    }

    @Test
    void shouldUpdateMileageOfAVehicle() {
        Vin vin = new Vin(VIN_TEST_VALUE);
        Vehicle vehicle = Vehicle.createNewVehicle(vin, new LicensePlate(LICENSE_PLATE_TEST_VALUE), new Mileage(MILEAGE_TEST_VALUE), VehicleTestDataFactory.createVehicleMasterData());
        Mileage expectedMileage = new Mileage(4000);

        when(findVehicle.findByVin(vin)).thenReturn(Optional.of(vehicle));
        when(saveVehicle.save(vehicle)).thenReturn(vehicle);

        Vehicle updatedVehicle = updateMileageInteractor.update(vin, expectedMileage);

        Mockito.verify(findVehicle).findByVin(vin);
        Mockito.verify(saveVehicle).save(vehicle);

        assertThat(updatedVehicle.getMileageRecords()).hasSize(2);
        assertThat(updatedVehicle.getMileageRecords().get(1).mileage()).isEqualTo(expectedMileage);
    }

    @Test
    void shouldThrowVehicleNotFoundException() {
        Vin vin = new Vin(VIN_TEST_VALUE);
        when(findVehicle.findByVin(vin)).thenReturn(Optional.empty());
        assertThrows(VehicleNotFoundException.class, () -> updateMileageInteractor.update(vin, new Mileage(4000)));
        Mockito.verify(findVehicle, Mockito.times(1)).findByVin(vin);
        Mockito.verify(saveVehicle, Mockito.times(0)).save(Mockito.any());
    }
}