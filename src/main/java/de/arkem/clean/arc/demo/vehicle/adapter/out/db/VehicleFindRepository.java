package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.VehicleDbEntity;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
class VehicleFindRepository implements FindVehicle {
    private final VehicleCrudRepository vehicleCrudRepository;
    private final VehicleToDbEntityMapper vehicleToDbEntityMapper;

    public VehicleFindRepository(VehicleCrudRepository vehicleCrudRepository, VehicleToDbEntityMapper vehicleToDbEntityMapper) {
        this.vehicleCrudRepository = vehicleCrudRepository;
        this.vehicleToDbEntityMapper = vehicleToDbEntityMapper;
    }

    @Override
    public Optional<Vehicle> findByVin(Vin vin) {
        return vin == null ? Optional.empty() : vehicleCrudRepository.findById(vin.value())
                .map(vehicleToDbEntityMapper::mapVehicleDbEntityToEntity);
    }

    @Override
    public List<Vehicle> findAll() {
        return ((List<VehicleDbEntity>) vehicleCrudRepository.findAll())
                .stream()
                .map(vehicleToDbEntityMapper::mapVehicleDbEntityToEntity)
                .collect(Collectors.toList());
    }
}
