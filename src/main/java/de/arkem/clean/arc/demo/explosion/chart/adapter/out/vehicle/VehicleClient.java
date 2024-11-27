package de.arkem.clean.arc.demo.explosion.chart.adapter.out.vehicle;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.VehicleData;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleByVin;
import org.springframework.stereotype.Component;

@Component
public class VehicleClient implements FetchVehicle {
    private final GetVehicleByVin getVehicleByVin;
    private final VehicleToDtoMapper mapper;

    public VehicleClient(GetVehicleByVin getVehicleByVin, VehicleToDtoMapper mapper) {
        this.getVehicleByVin = getVehicleByVin;
        this.mapper = mapper;
    }

    @Override
    public VehicleData fetch(String vin) {
        var vehicle = getVehicleByVin.get(new Vin(vin));
        return mapper.mapToDomain(vehicle);
    }
}
