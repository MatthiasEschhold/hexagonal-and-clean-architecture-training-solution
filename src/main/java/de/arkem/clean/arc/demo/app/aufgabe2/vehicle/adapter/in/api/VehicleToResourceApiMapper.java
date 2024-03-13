package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api.resource.EquipmentResource;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api.resource.MileageRecordResource;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api.resource.VehicleMasterDataResource;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.model.vehicle.mileage.record.MileageRecord;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;

@Mapper
public interface VehicleToResourceApiMapper {
    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "licensePlate.value", target = "licensePlate")
    @Mapping(source = "vehicleMasterData", target = "vehicleMasterData")
    @Mapping(source = "mileageRecords", target = "mileageRecords")
    VehicleResource mapVehicleToResource(Vehicle vehicle);

    @Mapping(source = "mileage.value", target = "mileage")
    @Mapping(source = "recordDate.value", target = "recordDate", qualifiedByName = "mapDateToString")
    MileageRecordResource mapMileageRecordToResource(MileageRecord entity);

    @Named("mapDateToString")
    public static String mapDateToString(Date date) {
        return date.toString();
    }
    @Mapping(source = "equipmentList", target = "equipmentList")
    @Mapping(source = "countryOfManufacture.value", target = "countryOfManufacture")
    VehicleMasterDataResource mapVehicleMasterDataToResource(VehicleMasterData entity);

    @Mapping(source = "equipmentCode.value", target = "equipmentCode")
    @Mapping(source = "equipmentLabel.value", target = "equipmentLabel")
    EquipmentResource mapEquipmentToResource(Equipment entity);

}
