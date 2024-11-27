package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.EquipmentDbEntity;
import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.MileageRecordDbEntity;
import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.VehicleDbEntity;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.ConstructionYear;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.MileageRecord;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.RecordDate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
class VehicleToDbEntityMapper {

    /**
     * Clean Code Principles: Single Level of Abstraction
     * Bezogen auf mapVehicleToDbEntity und die Aufteilung auf drei private Methoden
     *
     * @param vehicle
     * @return
     */
    public VehicleDbEntity mapVehicleToDbEntity(Vehicle vehicle) {
        var vehicleDbEntity = createAndMapVehicleDbEntity(vehicle);
        this.mapVehicleMasterDataToDbEntity(vehicle, vehicleDbEntity);
        this.mapMileageRecordsToDbEntity(vehicle, vehicleDbEntity);
        this.mapEquipmentListToDbEntity(vehicle, vehicleDbEntity);
        return vehicleDbEntity;
    }

    private VehicleDbEntity createAndMapVehicleDbEntity(Vehicle vehicle) {
        var vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vehicle.getVin().value());
        vehicleDbEntity.setLicensePlate(vehicle.getLicensePlate().value());
        return vehicleDbEntity;
    }

    private void mapVehicleMasterDataToDbEntity(Vehicle vehicle, VehicleDbEntity vehicleDbEntity) {
        vehicleDbEntity.setCountryOfManufacture(vehicle.getVehicleMasterData().countryOfManufacture().value());
    }

    private void mapEquipmentListToDbEntity(Vehicle vehicle, VehicleDbEntity vehicleDbEntity) {
        vehicleDbEntity.setEquipmentList(
                vehicle.getVehicleMasterData().equipmentList().stream()
                        .map(e -> new EquipmentDbEntity(e.equipmentCode().value(), e.equipmentLabel().value())).collect(Collectors.toList()));
    }

    private void mapMileageRecordsToDbEntity(Vehicle vehicle, VehicleDbEntity vehicleDbEntity) {
        vehicleDbEntity.setMileageRecords(vehicle.getMileageRecords()
                .stream()
                .map(mileageRecord -> new MileageRecordDbEntity(mileageRecord.mileage().value(),
                        mileageRecord.recordDate().value().toString())).collect(Collectors.toList()));
    }

    public Vehicle mapVehicleDbEntityToEntity(VehicleDbEntity vehicleDbEntity) {
        var vin = new Vin(vehicleDbEntity.getVin());
        var licensePlate = new LicensePlate(vehicleDbEntity.getLicensePlate());
        var countryOfManufacture = new CountryOfManufacture(vehicleDbEntity.getCountryOfManufacture());
        var vehicleModel = new VehicleModel(vehicleDbEntity.getVehicleModel());
        var constructionYear = new ConstructionYear(vehicleDbEntity.getConstructionYear());
        var equipmentList = mapEquipmentListToDomain(vehicleDbEntity);
        var mileageRecords = mapMileageRecordToDomain(vehicleDbEntity);
        var vehicleMasterData = new VehicleMasterData(vehicleModel, constructionYear, countryOfManufacture, equipmentList);
        return new Vehicle(vin, licensePlate, mileageRecords, vehicleMasterData);
    }

    private List<MileageRecord> mapMileageRecordToDomain(VehicleDbEntity vehicleDbEntity) {
        return vehicleDbEntity.getMileageRecords().stream()
                .map(mileageRecordDbEntity -> new MileageRecord(
                                new Mileage(mileageRecordDbEntity.getMileage()),
                                new RecordDate(LocalDateTime.parse(mileageRecordDbEntity.getRecordTime()))
                        )
                )
                .collect(Collectors.toList());
    }

    private List<Equipment> mapEquipmentListToDomain(VehicleDbEntity vehicleDbEntity) {
        return vehicleDbEntity.getEquipmentList().stream()
                .map(e -> new Equipment(
                                new EquipmentCode(e.getEquipmentCode()),
                                new EquipmentLabel(e.getEquipmentLabel())
                        )
                )
                .collect(Collectors.toList());
    }
}
