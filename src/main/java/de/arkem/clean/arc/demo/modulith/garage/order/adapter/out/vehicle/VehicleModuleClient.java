package de.arkem.clean.arc.demo.modulith.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.modulith.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.garage.order.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.in.GetVehicleByLicensePlate;

import java.util.Optional;

public class VehicleModuleClient implements FetchVehicle {
    private final GetVehicleByLicensePlate getVehicleByLicensePlate;
    private final VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(GetVehicleByLicensePlate getVehicleByLicensePlate, VehicleToOriginVehicleMapper mapper) {
        this.getVehicleByLicensePlate = getVehicleByLicensePlate;
        this.mapper = mapper;
    }

    @Override
    public Optional<Vehicle> fetch(LicensePlate licensePlate) {
        de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle vehicle = getVehicleByLicensePlate.get(new
                de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.LicensePlate(licensePlate.getValue()));
        if (vehicle == null) {
            return Optional.empty();
        }
        return Optional.of(mapper.mapOriginVehicleToVehicle(vehicle));
    }
}
