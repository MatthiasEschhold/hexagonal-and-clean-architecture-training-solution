package de.arkem.clean.arc.demo.explosion.chart.adapter.in.api;

import de.arkem.clean.arc.demo.explosion.chart.adapter.in.api.resource.*;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.Category;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.ExplosionChartResponse;
import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.SparePartData;
import de.arkem.shared.resource.PriceConfigurationResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExplosionChartToResourceMapper {
    public ExplosionChartResource mapToResource(ExplosionChartResponse response) {
        var explosionChartResource = new ExplosionChartResource();
        explosionChartResource.setName(response.chartName().getValue());
        explosionChartResource.setMainCategory(mapToCategoryResource(response.partsCategory().getMainCategory()));
        explosionChartResource.setSubCategory(mapToCategoryResource(response.partsCategory().getSubCategory()));
         explosionChartResource.setVehicle(mapToVehicleResource(response.vehicle()));
        explosionChartResource.setSpareParts(mapToSparePartsResourceList(response.spareParts()));
        return explosionChartResource;
    }

    private CategoryResource mapToCategoryResource(Category entity) {
        var categoryResource = new CategoryResource();
        categoryResource.setNumber(entity.getNumber().getValue());
        return categoryResource;
    }

    private List<SparePartResource> mapToSparePartsResourceList(List<SparePartData> entities) {
        return entities.stream().map(sparePart -> {
            var sparePartResource = new SparePartResource();
            sparePartResource.setSparePartNumber(sparePart.partNumber());
            sparePartResource.setSparePartName(sparePart.partName());
            sparePartResource.setPriceConfiguration(mapToPriceConfigurationResource(sparePart));
            return sparePartResource;
        }).collect(Collectors.toList());
    }

    private PriceConfigurationResource mapToPriceConfigurationResource(SparePartData sparePartData) {
        var priceConfiguration = new PriceConfigurationResource();
        priceConfiguration.setNetPrice(sparePartData.netPrice());
        priceConfiguration.setNetPriceRecommodation(sparePartData.netPriceRecommodation());
        priceConfiguration.setCurrency(sparePartData.currency());
        return priceConfiguration;
    }

    private VehicleResource mapToVehicleResource(ExplosionChartVehicle entity) {
        VehicleResource vehicleResource = new VehicleResource();
        vehicleResource.setVehicleModel(entity.getModel().getValue());
        vehicleResource.setFromConstructionYear(entity.getFromConstructionYear().getValue());
        vehicleResource.setToConstructionYear(entity.getFromConstructionYear().getValue());
        return vehicleResource;
    }
}
