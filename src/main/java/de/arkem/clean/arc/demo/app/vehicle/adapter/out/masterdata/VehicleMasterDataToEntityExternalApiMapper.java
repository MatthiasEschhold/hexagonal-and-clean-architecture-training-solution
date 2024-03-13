package de.arkem.clean.arc.demo.app.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMasterDataToEntityExternalApiMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(new CountryOfManufacture(resource.getOriginCountry()), equipmentList);
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}
