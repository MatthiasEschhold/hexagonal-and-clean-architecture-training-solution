package de.arkem.clean.arc.demo.modulith.parts.catalog.application;

import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.PartsCatalogView;
import de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.parts.category.CategoryNumber;
import de.arkem.clean.arc.demo.modulith.parts.catalog.usecase.in.LoadPartsCatalogView;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.modulith.vehicle.usecase.in.GetVehicleByVin;

public class PartsCatalogViewApplicationService {
    private final GetVehicleByVin getVehicleByVin;
    private final LoadPartsCatalogView loadPartsCatalogView;
    private final VehicleMapper mapper;

    public PartsCatalogViewApplicationService(GetVehicleByVin getVehicleByVin, LoadPartsCatalogView loadPartsCatalogView, VehicleMapper mapper) {
        this.getVehicleByVin = getVehicleByVin;
        this.loadPartsCatalogView = loadPartsCatalogView;
        this.mapper = mapper;
    }

    public PartsCatalogView loadPartsCatalog(LoadPartsCatalogViewCommand command) {
        Vehicle vehicle = getVehicleByVin.get(new Vin(command.vin()));
        return loadPartsCatalogView.load(new CategoryNumber(command.mainCategory()), new CategoryNumber(command.subCategory()),
                mapper.mapOriginVehicleToVehicle(vehicle));
    }
}
