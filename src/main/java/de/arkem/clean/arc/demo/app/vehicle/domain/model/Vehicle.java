package de.arkem.clean.arc.demo.app.vehicle.domain.model;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.MileageRecord;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.RecordDate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Vehicle {
    private Vin vin;
    private LicensePlate licensePlate;
    private List<MileageRecord> mileageRecords;
    private VehicleMasterData vehicleMasterData;

    private Vehicle(Vin vin, LicensePlate licensePlate) {
        this.vin = vin;
        this.licensePlate = licensePlate;
    }

    /**
     * Constructor um ein neues Fahrzeug im Kontext des Anwendungsfall Fahrzeuganlegen
     * @param vin
     * @param licensePlate
     * @param mileage
     */
    public Vehicle(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        this(vin, licensePlate);
        validateMandatoryData(vin, licensePlate, mileage);
        createInitialMileageRecordList(mileage);
    }

    /**
     * Constructor um ein neues Fahrzeug im Kontext des Anwendungsfall Fahrzeug lesen
     * @param vin
     * @param licensePlate
     * @param mileageRecords
     */
    public Vehicle(Vin vin, LicensePlate licensePlate, List<MileageRecord> mileageRecords) {
        this(vin, licensePlate);
        this.mileageRecords = mileageRecords;
    }
    public void updateMileage(Mileage mileage) {
        if(mileage != null && isMileageRecordPlausible(mileage)) {
            mileageRecords.add(new MileageRecord(mileage, new RecordDate(new Date())));
        } else {
            throw new IllegalArgumentException("mileage is not valid");
        }
    }

    public Mileage findLatestMileage() {
        if (mileageRecords.isEmpty()) {
            return null;
        }

        MileageRecord latestMileageRecord = mileageRecords.stream()
                .max(Comparator.comparing(mileageRecord -> mileageRecord.recordDate().value()))
                .orElse(null);

        return latestMileageRecord != null ? latestMileageRecord.mileage() : null;
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
    private boolean isMileageRecordPlausible(Mileage mileage) {
        return getLatestMileageRecord().mileage().value() < mileage.value();
    }
    private MileageRecord getLatestMileageRecord() {
        return null;
    }
    private void validateMandatoryData(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        if (vin == null || licensePlate == null || mileage == null) {
            throw new IllegalArgumentException("vehicle is not valid");
        }
    }

    private void createInitialMileageRecordList(Mileage mileage) {
        this.mileageRecords = new ArrayList<>();
        this.mileageRecords.add(new MileageRecord(mileage, new RecordDate(new Date())));
    }

    /**
     * Static Factory Methode um ein neues Fahrzeug zu erstellen, oft ein aussagekräftigere und
     * flexiblere Alternative zu einem Konstruktor
     * @param vin
     * @param licensePlate
     * @param mileage
     * @return
     */
    public static Vehicle createNewVehicle(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        Vehicle vehicle = new Vehicle(vin, licensePlate);
        List<MileageRecord> mileageRecords = new ArrayList<>();
        mileageRecords.add(new MileageRecord(mileage, new RecordDate(new Date())));
        return vehicle;
    }
}