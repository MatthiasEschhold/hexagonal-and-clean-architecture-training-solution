package de.arkem.clean.arc.demo.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.garage.order.usecase.in.GarageOrderCommand;
import de.arkem.clean.arc.demo.garage.order.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.clean.arc.demo.garage.order.usecase.out.GarageOrderDbQuery;
import org.springframework.stereotype.Component;

@Component
class GarageOrderCommandInteractor implements GarageOrderCommand {

    private final GarageOrderDbCommand dbCommand;
    private final GarageOrderDbQuery dbQuery;
    private final FetchVehicle fetchVehicle;

    public GarageOrderCommandInteractor(GarageOrderDbCommand dbCommand, GarageOrderDbQuery dbQuery, FetchVehicle fetchVehicle) {
        this.dbCommand = dbCommand;
        this.dbQuery = dbQuery;
        this.fetchVehicle = fetchVehicle;
    }

    @Override
    public GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand) {
        var vehicle = fetchVehicle.fetch(createGarageOrderCommand.licensePlate())
                .orElseThrow(() -> new IllegalArgumentException("vehicle not found, please create vehicle first."));
        return dbCommand.save(new GarageOrder(vehicle));
    }

    @Override
    public GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand) {
        var garageOrder = findGarageOrder(updateGarageOrderCommand);
        garageOrder.addOrderPositions(updateGarageOrderCommand.orderItems());
        return dbCommand.save(garageOrder);
    }

    private GarageOrder findGarageOrder(UpdateGarageOrderCommand updateGarageOrderCommand) {
        return dbQuery.findByOrderNumber(updateGarageOrderCommand.orderNumber())
                .orElseThrow(() -> new IllegalArgumentException("garage order not found."));
    }
}
