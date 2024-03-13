package de.arkem.clean.arc.demo.app.vehicle.test.data;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.MileageRecord;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.RecordDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VehicleTestDataFactory {
    public static final String VIN_TEST_VALUE = "WP0ZZZ99ZTS392155";
    public static final String LICENSE_PLATE_TEST_VALUE = "AB-CD 1234";

    public static final Double MILEAGE_TEST_VALUE = 1000.00;

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

    public static MileageRecord createMileageRecord(double value, int nanoSecond) {
        return new MileageRecord(new Mileage(value), new RecordDate(createLocalDateTime(nanoSecond)));
    }

    private static LocalDateTime createLocalDateTime(int nanoSecond) {
        LocalDate date = LocalDate.of(2024, 3, 1);
        LocalTime time = LocalTime.of(12, 0, 30, nanoSecond);
        return LocalDateTime.of(date, time);
    }

    public static VehicleMasterData createVehicleMasterData() {
        return new VehicleMasterData(new CountryOfManufacture("DE"),
                List.of(new Equipment(new EquipmentCode("AB1234"), new EquipmentLabel("test"))));
    }
}