package de.arkem.clean.arc.demo.modulith.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;

import java.util.stream.Collectors;

public class VehicleToDbEntityDbMapper {
    public VehicleDbEntity mapVehicleToDbEntity(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vehicle.getVin().value());
        vehicleDbEntity.setMileageRecords(vehicle.getMileageRecords()
                .stream()
                .map(mileageRecord -> new MileageRecordDbEntity(mileageRecord.mileage().value(),
                        mileageRecord.recordDate().value().toString())).collect(Collectors.toList()));
        return vehicleDbEntity;
    }

    public Vehicle mapVehicleDbEntityToEntity(VehicleDbEntity vehicleDbEntity) {
        return null;
    }
}
