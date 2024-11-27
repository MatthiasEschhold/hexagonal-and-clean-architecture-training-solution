package de.arkem.clean.arc.demo.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.garage.order.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.GarageOrderVehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleByLicensePlate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleModuleClient implements FetchVehicle {
    private final GetVehicleByLicensePlate getVehicleByLicensePlate;
    private final VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(GetVehicleByLicensePlate getVehicleByLicensePlate, VehicleToOriginVehicleMapper mapper) {
        this.getVehicleByLicensePlate = getVehicleByLicensePlate;
        this.mapper = mapper;
    }

    @Override
    public Optional<GarageOrderVehicle> fetch(LicensePlate licensePlate) {
        var vehicle = getVehicleByLicensePlate.get(new de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate(licensePlate.getValue()));
        if (vehicle == null) {
            return Optional.empty();
        }
        return Optional.of(mapper.mapOriginVehicleToVehicle(vehicle));
    }
}
