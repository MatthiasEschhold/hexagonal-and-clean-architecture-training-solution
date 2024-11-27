package de.arkem.clean.arc.demo.vehicle.test.data;

import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.EquipmentResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.MileageRecordResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.VehicleMasterDataResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.VehicleResource;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleTestDataFactory {
    public static final String VIN_TEST_VALUE = "WP0ZZZ99ZTS392155";
    public static final String LICENSE_PLATE_TEST_VALUE = "AB-CD 1234";
    public static final Double MILEAGE_TEST_VALUE = 1000.00;
    public static final String COUNTRY_OF_MANUFACTURE_TEST_VALUE = "DE";

    public static final String VEHICLE_MODEL_TEST_VALUE = "BMW 318i";
    public static final int CONSTRUCTION_YEAR_TEST_VALUE = 2020;

    public static Vehicle createVehicle(String vin, String licensePlate) {
        return new Vehicle(new Vin(vin),
                new LicensePlate(licensePlate),
                createMileageRecords(),
                createVehicleMasterData());
    }

    public static Vehicle createVehicle() {
        return new Vehicle(new Vin(VIN_TEST_VALUE),
                new LicensePlate(LICENSE_PLATE_TEST_VALUE),
                createMileageRecords(),
                createVehicleMasterData());
    }

    public static List<MileageRecord> createMileageRecords() {
        MileageRecord mileageRecord = createMileageRecord(MILEAGE_TEST_VALUE, 1);
        MileageRecord mileageRecord2 = createMileageRecord(2000.00, 2);
        MileageRecord mileageRecord3 = createMileageRecord(3000.00, 3);
        List<MileageRecord> mileageRecords = new ArrayList<>();
        mileageRecords.add(mileageRecord);
        mileageRecords.add(mileageRecord2);
        mileageRecords.add(mileageRecord3);
        return mileageRecords;
    }

    public static Equipment createEquipment(String code, String label) {
        return new Equipment(new EquipmentCode(code), new EquipmentLabel(label));
    }

    public static MileageRecord createMileageRecord(double value, int factor) {
        return new MileageRecord(new Mileage(value), new RecordDate(createLocalDateTime(factor)));
    }

    private static LocalDateTime createLocalDateTime(int factor) {
        LocalDate date = LocalDate.of(2024, 3, factor);
        LocalTime time = LocalTime.of(12, 0, 30 + factor);
        return LocalDateTime.of(date, time);
    }

    public static VehicleMasterData createVehicleMasterData() {
        return new VehicleMasterData(createVehicleModel(), createConstructionYear(), new CountryOfManufacture("DE"), createEquipmentList());
    }

    private static List<Equipment> createEquipmentList() {
        return List.of(
                new Equipment(new EquipmentCode("AB1234"), new EquipmentLabel("Beleuchtete Aussenspiegel")),
                new Equipment(new EquipmentCode("ZD1234"), new EquipmentLabel("Integrierte Standheizung")),
                new Equipment(new EquipmentCode("AX1345"), new EquipmentLabel("Head-Up Display"))
        );
    }

    public static VehicleDbEntity constructVehicleDbEntity() {
        var vehicleDbEntity = createVehicleDbEntity(VIN_TEST_VALUE, LICENSE_PLATE_TEST_VALUE, COUNTRY_OF_MANUFACTURE_TEST_VALUE);
        enrichWithMileageRecords(vehicleDbEntity);
        enrichWithEquipmentList(vehicleDbEntity);
        return vehicleDbEntity;
    }

    private static void enrichWithEquipmentList(VehicleDbEntity vehicleDbEntity) {
        vehicleDbEntity.setEquipmentList(createEquipmentList().stream()
                .map(e -> VehicleTestDataFactory.mapToEquipmentDbEntity(e))
                .collect(Collectors.toList()));
    }

    private static void enrichWithMileageRecords(VehicleDbEntity vehicleDbEntity) {
        vehicleDbEntity.setMileageRecords(
                createMileageRecords().stream()
                        .map(mr -> VehicleTestDataFactory.mapToMileageRecordDbEntity(mr))
                        .collect(Collectors.toList()));
    }

    private static VehicleDbEntity createVehicleDbEntity(String vin, String licensePlate, String countryOfManufacture) {
        var vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vin);
        vehicleDbEntity.setLicensePlate(licensePlate);
        vehicleDbEntity.setCountryOfManufacture(countryOfManufacture);
        return vehicleDbEntity;
    }

    private static EquipmentDbEntity mapToEquipmentDbEntity(Equipment equipment) {
        var equipmentDbEntity = new EquipmentDbEntity();
        equipmentDbEntity.setEquipmentCode(equipment.equipmentCode().value());
        equipmentDbEntity.setEquipmentLabel(equipment.equipmentLabel().value());
        return equipmentDbEntity;
    }

    private static MileageRecordDbEntity mapToMileageRecordDbEntity(MileageRecord mileageRecord) {
        var mileageRecordDbEntity = new MileageRecordDbEntity();
        mileageRecordDbEntity.setMileage(mileageRecord.mileage().value());
        mileageRecordDbEntity.setRecordTime(mileageRecord.recordDate().value().toString());
        return mileageRecordDbEntity;
    }

    public static VehicleResource constructVehicleResource() {
        var resource = createVehicleResource(VIN_TEST_VALUE, LICENSE_PLATE_TEST_VALUE);
        var vehicleMasterDataResource = createVehicleMasterDataResource();
        resource.setVehicleMasterData(vehicleMasterDataResource);
        return resource;
    }

    private static VehicleResource createVehicleResource(String vin, String licensePlate) {
        var resource = new VehicleResource();
        resource.setVin(VIN_TEST_VALUE);
        resource.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        resource.setMileageRecords(createMileageRecords().stream()
                .map(mr -> VehicleTestDataFactory.mapToMileageRecordResource(mr))
                .collect(Collectors.toList()));
        return resource;
    }

    private static VehicleMasterDataResource createVehicleMasterDataResource() {
        List<EquipmentResource> equipmentResourceList = createEquipmentResourceList();
        var vehicleMasterDataResource = new VehicleMasterDataResource();
        vehicleMasterDataResource.setEquipmentList(equipmentResourceList);
        vehicleMasterDataResource.setCountryOfManufacture(COUNTRY_OF_MANUFACTURE_TEST_VALUE);
        return vehicleMasterDataResource;
    }

    private static List<EquipmentResource> createEquipmentResourceList() {
        List<EquipmentResource> equipmentResourceList = (createEquipmentList().stream()
                .map(e -> VehicleTestDataFactory.mapToEquipmentResource(e))
                .collect(Collectors.toList()));
        return equipmentResourceList;
    }

    private static EquipmentResource mapToEquipmentResource(Equipment e) {
        var resource = new EquipmentResource();
        resource.setEquipmentCode(e.equipmentCode().value());
        resource.setEquipmentLabel(e.equipmentLabel().value());
        return resource;
    }

    private static MileageRecordResource mapToMileageRecordResource(MileageRecord mr) {
        var resource = new MileageRecordResource();
        resource.setMileage(mr.mileage().value());
        resource.setRecordDate(mr.recordDate().value());
        return resource;
    }

    public static VehicleModel createVehicleModel() {
        return new VehicleModel(VEHICLE_MODEL_TEST_VALUE);
    }

    public static ConstructionYear createConstructionYear() {
        return new ConstructionYear(CONSTRUCTION_YEAR_TEST_VALUE);
    }
}