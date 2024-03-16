package de.arkem.clean.arc.demo.modulith.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.out.FindVehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.out.SaveVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        LicensePlate licensePlate = new LicensePlate(LICENSE_PLATE_TEST_VALUE);
        Vehicle vehicle = new Vehicle(vin, licensePlate, new Mileage(MILEAGE_TEST_VALUE), getVehicleMasterData());
        when(findVehicle.findByVin(vin)).thenReturn(vehicle);
        when(saveVehicle.save(vehicle)).thenReturn(vehicle);

        assertDoesNotThrow(() -> updateMileageInteractor.update(vin, new Mileage(2000)));
    }

    private VehicleMasterData getVehicleMasterData() {
        return new VehicleMasterData(new CountryOfManufacture("DE"),
                Arrays.asList(new Equipment(new EquipmentCode("BA1234"), new EquipmentLabel("Test Equipment"))));
    }
}