package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.MileageRecord;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.RecordDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Vehicle {
    private final Vin vin;
    private final LicensePlate licensePlate;
    private final List<MileageRecord> mileageRecords;
    private final VehicleMasterData vehicleMasterData;

    public Vehicle(Vin vin, LicensePlate licensePlate, List<MileageRecord> mileageRecords, VehicleMasterData vehicleMasterData) {
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.mileageRecords = mileageRecords;
        this.vehicleMasterData = vehicleMasterData;
        validate(vin, licensePlate, mileageRecords, vehicleMasterData);
    }

    /**
     * Static Factory Methode um ein neues Fahrzeug zu erstellen, oft ein aussagekräftigere und
     * flexiblere Alternative zu einem Konstruktor
     *
     * @param vin
     * @param licensePlate
     * @param mileage
     * @return
     */
    public static Vehicle createNewVehicle(Vin vin, LicensePlate licensePlate, Mileage mileage, VehicleMasterData vehicleMasterData) {
        var mileageRecords = new ArrayList<>(List.of(MileageRecord.createMileageRecord(mileage)));
        validate(vin, licensePlate, mileageRecords, vehicleMasterData);
        return new Vehicle(vin, licensePlate, mileageRecords, vehicleMasterData);
    }

    private static void validate(Vin vin, LicensePlate licensePlate, List<MileageRecord> mileageRecords, VehicleMasterData vehicleMasterData) {
        if (vin == null || licensePlate == null || mileageRecords.isEmpty() || vehicleMasterData == null) {
            throw new IllegalArgumentException("vehicle is not valid");
        }
    }

    public void updateMileage(Mileage mileage) {
        if (mileage != null && isNewMileageHigherThanThePreviousMileage(mileage)) {
            RecordDate recordDate = new RecordDate(LocalDateTime.now());
            mileageRecords.add(new MileageRecord(mileage, recordDate));
        } else {
            throw new IllegalArgumentException("kilometerstand is not valid");
        }
    }

    public Optional<Mileage> findLatestMileage() {
        MileageRecord latestMileageRecord = mileageRecords.stream()
                .max(Comparator.comparing(mileageRecord -> mileageRecord.recordDate().value()))
                .orElse(null);
        if (latestMileageRecord == null) {
            return Optional.empty();
        }
        return Optional.of(latestMileageRecord.mileage());
    }

    public Vin getVin() {
        return vin;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public List<MileageRecord> getMileageRecords() {
        return mileageRecords;
    }

    public VehicleMasterData getVehicleMasterData() {
        return vehicleMasterData;
    }

    private boolean isNewMileageHigherThanThePreviousMileage(Mileage mileage) {
        Optional<Mileage> latestMileageRecord = findLatestMileage();
        if (latestMileageRecord.isEmpty()) {
            return true;
        } else {
            if (latestMileageRecord.get().value() <= mileage.value()) {
                return true;
            }
        }
        return false;
    }
}
