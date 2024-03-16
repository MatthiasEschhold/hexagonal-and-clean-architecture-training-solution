package de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api;

import de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource.ExplosionChartResource;
import de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource.PartsCatalogViewResource;
import de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource.SparePartResource;
import de.arkem.clean.arc.demo.app.parts.catalog.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.PartsCatalogView;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.explosion.chart.ExplosionChart;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class PartsCatalogViewToResourceMapper {
    public PartsCatalogViewResource mapToResource(PartsCatalogView entity) {
        PartsCatalogViewResource resource = new PartsCatalogViewResource();
        resource.setSpareParts(mapToSparePartsResourceList(entity));
        resource.setVehicle(mapToVehicleResource(entity.getVehicle()));
        resource.setExplosionChart(mapToExplosionChartResource(entity.getExplosionChart()));
        return resource;
    }

    private List<SparePartResource> mapToSparePartsResourceList(PartsCatalogView entity) {
        return entity.getSpareParts().stream().map(sparePart -> {
            SparePartResource sparePartResource = new SparePartResource();
            sparePartResource.setSparePartName(sparePart.getSparePartName().getValue());
            sparePartResource.setSparePartNumber(sparePart.getSparePartNumber().getValue());
            sparePartResource.setExplosionChartNumber(sparePart.getExplosionChartNumber().getValue());
            sparePartResource.setPrice(sparePart.getPrice().getValue());
            return sparePartResource;
        }).collect(Collectors.toList());
    }

    private ExplosionChartResource mapToExplosionChartResource(ExplosionChart explosionChart) {
        ExplosionChartResource explosionChartResource = new ExplosionChartResource();
        explosionChartResource.setExplosionChartId(explosionChart.getId().getValue());
        explosionChartResource.setName(explosionChart.getName().getValue());
        explosionChartResource.setDescription(explosionChart.getDescription().getValue());
        return explosionChartResource;
    }

    private VehicleResource mapToVehicleResource(Vehicle vehicle) {
        VehicleResource vehicleResource = new VehicleResource();
        vehicleResource.setVin(vehicle.getVin().getValue());
        vehicleResource.setVehicleConstructionSerie(vehicle.getVehicleConstructionSerie().getValue());
        vehicleResource.setConstructionSerieVariant(vehicle.getConstructionSerieVariant().getValue());
        vehicleResource.setEquipmentCodes(vehicle.getEquipmentCodes().stream().map(equipmentCode -> equipmentCode.getValue()).collect(Collectors.toList()));
        return vehicleResource;
    }
}
