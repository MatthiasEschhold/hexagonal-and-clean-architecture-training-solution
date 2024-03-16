package de.arkem.clean.arc.demo.modulith.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.out.SaveVehicle;

public class VehicleDbRepository implements SaveVehicle {

    private final VehicleToDbEntityDbMapper mapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityDbMapper mapper, VehicleCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }


    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = crudRepository.save(mapper.mapVehicleToDbEntity(vehicle));
        return mapper.mapVehicleDbEntityToEntity(vehicleDbEntity);
    }
}
