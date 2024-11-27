package de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.EquipmentListDto;
import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExplosionChartVehicleMasterDataToDtoMapperTest {

    @Test
    void mapVehicleMasterDataToEntity() {
        var vehicleMasterDataDto = createVehicleDataDto(VehicleTestDataFactory.VIN_TEST_VALUE);
        var vehicleMasterData = new VehicleMasterDataToDtoMapper().mapVehicleMasterDataToEntity(vehicleMasterDataDto);
        assertThat(vehicleMasterData.countryOfManufacture().value()).isEqualTo(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE);
        assertThat(vehicleMasterData.equipmentList().size()).isEqualTo(3);
        assertThat(vehicleMasterData.vehicleModel().value()).isEqualTo(VehicleTestDataFactory.VEHICLE_MODEL_TEST_VALUE);
        assertThat(vehicleMasterData.constructionYear().value()).isEqualTo(VehicleTestDataFactory.CONSTRUCTION_YEAR_TEST_VALUE);
    }

    private VehicleDataDto createVehicleDataDto(String vin) {
        var vehicle = new VehicleDataDto();
        vehicle.setVehicleId(vin);
        vehicle.setVehicleType(VehicleTestDataFactory.VEHICLE_MODEL_TEST_VALUE);
        vehicle.setConstructionYear(VehicleTestDataFactory.CONSTRUCTION_YEAR_TEST_VALUE);
        vehicle.setOriginCountry(VehicleTestDataFactory.COUNTRY_OF_MANUFACTURE_TEST_VALUE);
        var equipmentList = new EquipmentListDto();
        equipmentList.setList(List.of(createEquipmentDto(1),
                createEquipmentDto(2),
                createEquipmentDto(3)));
        vehicle.setEquipmentListDto(equipmentList);
        return vehicle;
    }

    private EquipmentDto createEquipmentDto(int index) {
        var dto = new EquipmentDto();
        dto.setCode("AB12" + (index * 10));
        dto.setName("Equipment" + (index * 10));
        return dto;
    }
}