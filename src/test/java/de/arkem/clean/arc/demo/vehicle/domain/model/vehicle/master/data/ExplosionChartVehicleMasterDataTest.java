package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory.createConstructionYear;
import static de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory.createVehicleModel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExplosionChartVehicleMasterDataTest {

    @Test
    void shouldCreateValidVehicleMasterDataValueObject() {
        VehicleMasterData masterData = getVehicleMasterData();
        assertThat(masterData.equipmentList(), hasSize(1));
        assertThat(masterData.equipmentList(), contains(VehicleTestDataFactory.createEquipment("AB1234", "test")));
    }

    private VehicleMasterData getVehicleMasterData() {
        List<Equipment> list = getEquipment();
        VehicleMasterData masterData = new VehicleMasterData(
                createVehicleModel(),
                createConstructionYear(),
                new CountryOfManufacture("DE"), list);
        return masterData;
    }

    private List<Equipment> getEquipment() {
        List<Equipment> list = new ArrayList<>();
        list.add(VehicleTestDataFactory.createEquipment("AB1234", "test"));
        return list;
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullCountryOfManufacture() {
        assertThrows(IllegalArgumentException.class, () ->
                new VehicleMasterData(createVehicleModel(), createConstructionYear(), null, getEquipment()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToEmptyEquipmentList() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMasterData(createVehicleModel(), createConstructionYear(), new CountryOfManufacture("DE"), new ArrayList<>()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullList() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMasterData(createVehicleModel(), createConstructionYear(), new CountryOfManufacture("DE"), null));
    }
}