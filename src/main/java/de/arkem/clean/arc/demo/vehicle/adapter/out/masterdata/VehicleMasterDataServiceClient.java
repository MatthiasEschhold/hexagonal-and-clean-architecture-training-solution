package de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata;


import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.EquipmentListDto;
import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchVehicleMasterData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class VehicleMasterDataServiceClient implements FetchVehicleMasterData {
    private final VehicleMasterDataToDtoMapper externalApiMapper;
    public VehicleMasterDataServiceClient(VehicleMasterDataToDtoMapper externalApiMapper) {
        this.externalApiMapper = externalApiMapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        VehicleDataDto vehicleDataDto = callVehicleMasterDataService(vin.value());
        return externalApiMapper.mapVehicleMasterDataToEntity(vehicleDataDto);
    }

    private VehicleDataDto callVehicleMasterDataService(String vin) {
        return new VehicleDataDtoFactory().createVehicleDataDto(vin);
    }

    private class VehicleDataDtoFactory {
        public VehicleDataDto createVehicleDataDto(String vin) {
            var vehicle = createVehicle(vin);
            var equipmentList = new EquipmentListDto();
            equipmentList.setList(List.of(
                    createEquipmentDto(1),
                    createEquipmentDto(2),
                    createEquipmentDto(3)));
            vehicle.setEquipmentListDto(equipmentList);
            return vehicle;
        }

        private VehicleDataDto createVehicle(String vin) {
            var vehicle = new VehicleDataDto();
            vehicle.setVehicleId(vin);
            vehicle.setOriginCountry("DE");
            return vehicle;
        }

        private EquipmentDto createEquipmentDto(int index) {
            var dto = new EquipmentDto();
            dto.setCode("AB12" + (index * 10));
            dto.setName("Equipment" + (index * 10));
            return dto;
        }
    }
}
