package de.arkem.clean.arc.demo.app.garage.order.usecase.interactor.command;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.garage.order.usecase.in.GarageOrderCommand;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.AddOrderPositions;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.clean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;
import org.springframework.transaction.annotation.Transactional;

public class GarageOrderCommandInteractor implements GarageOrderCommand {

    private final GarageOrderDbCommand dbCommand;
    private final GarageOrderDbQuery dbQuery;
    private final FetchVehicle fetchVehicle;
    private final AddOrderPositions addOrderPositions;

    public GarageOrderCommandInteractor(GarageOrderDbCommand dbCommand, GarageOrderDbQuery dbQuery, FetchVehicle fetchVehicle, AddOrderPositions addOrderPositions) {
        this.dbCommand = dbCommand;
        this.dbQuery = dbQuery;
        this.fetchVehicle = fetchVehicle;
        this.addOrderPositions = addOrderPositions;
    }

    @Override
    public GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand) {
        Vehicle vehicle = fetchVehicle.fetch(createGarageOrderCommand.licensePlate())
                .orElseThrow(() -> new IllegalArgumentException("vehicle not found, please create vehicle first."));
        return dbCommand.save(GarageOrder.createNewGarageOrder(vehicle));
    }

    @Override
    @Transactional
    public GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand) {
        GarageOrder garageOrder = findGarageOrder(updateGarageOrderCommand);
        garageOrder.addOrderPosition(updateGarageOrderCommand.orderPositions());
        return dbCommand.save(garageOrder);
    }

    public GarageOrder updateWithoutFetch(UpdateGarageOrderCommand updateGarageOrderCommand) {
        addOrderPositions.add(updateGarageOrderCommand.orderNumber(), updateGarageOrderCommand.orderPositions());
        return findGarageOrder(updateGarageOrderCommand);
    }

    private GarageOrder findGarageOrder(UpdateGarageOrderCommand updateGarageOrderCommand) {
        return dbQuery.findByOrderNumber(updateGarageOrderCommand.orderNumber())
                .orElseThrow(() -> new IllegalArgumentException("garage order not found."));
    }
}
