package de.arkem.clean.arc.demo.garage.order.adapter.in;

import de.arkem.clean.arc.demo.garage.order.adapter.in.entity.GarageOrderResource;
import de.arkem.clean.arc.demo.garage.order.adapter.in.entity.PriceResource;
import de.arkem.clean.arc.demo.garage.order.adapter.in.entity.VehicleResource;
import de.arkem.clean.arc.demo.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.garage.order.domain.model.price.Price;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.GarageOrderVehicle;
import org.springframework.stereotype.Component;

@Component
public class GarageOrderResourceToDomainMapper {

    public GarageOrderResource mapToResource(GarageOrder entity) {
        var resource = new GarageOrderResource();
        resource.setTotalExecutionTime(entity.getTotalExecutionTime().getValue());
        resource.setGrossPrice(mapToPriceResource(entity.getTotalGrossPrice()));
        resource.setNetPrice(mapToPriceResource(entity.getTotalNetPrice()));
        resource.setOrderNumber(entity.getOrderNumber().getValue());
        resource.setVehicle(mapToVehicleResource(entity.getVehicle()));
        return resource;
    }

    private VehicleResource mapToVehicleResource(GarageOrderVehicle entity) {
        var resource = new VehicleResource();
        resource.setVin(entity.getVin().getValue());
        resource.setLicensePlate(entity.getLicensePlate().getValue());
        resource.setMileage(entity.getMileage().getValue());
        return resource;
    }
    private PriceResource mapToPriceResource(Price price) {
        var resource = new PriceResource();
        resource.setCurrency(price.getCurrency().getValue());
        resource.setPriceValue(price.getPriceValue().getValue());
        return resource;
    }
}
