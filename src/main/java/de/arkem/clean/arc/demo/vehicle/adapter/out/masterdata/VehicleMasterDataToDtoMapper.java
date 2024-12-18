package de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.clean.arc.demo.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.ConstructionYear;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class VehicleMasterDataToDtoMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(new VehicleModel(resource.getVehicleType()), new ConstructionYear(resource.getConstructionYear()),
                new CountryOfManufacture(resource.getOriginCountry()), equipmentList);
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}
