package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.VehicleDbEntity;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.out.SaveVehicle;
import org.springframework.stereotype.Component;

@Component
class VehicleDbRepository implements SaveVehicle {
    private final VehicleToDbEntityMapper mapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityMapper mapper, VehicleCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = crudRepository.save(mapper.mapVehicleToDbEntity(vehicle));
        return mapper.mapVehicleDbEntityToEntity(vehicleDbEntity);
    }
}
