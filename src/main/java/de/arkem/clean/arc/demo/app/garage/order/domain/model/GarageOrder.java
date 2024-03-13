package de.arkem.clean.arc.demo.app.garage.order.domain.model;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.position.OrderPosition;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import io.github.domainprimitives.object.Aggregate;

import java.util.List;

public class GarageOrder extends Aggregate {
    private Vehicle vehicle;
    private OrderNumber orderNumber;
    private List<OrderPosition> positions;

    private GarageOrder() {
    }

    public GarageOrder(Vehicle vehicle, OrderNumber orderNumber, List<OrderPosition> positions) {
        this.vehicle = vehicle;
        this.orderNumber = orderNumber;
        this.positions = positions;
        this.validate();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public void addOrderPosition(List<OrderPosition> orderPositions) {
        this.positions.addAll(orderPositions);
    }

    @Override
    protected void validate() {
        if (vehicle == null || positions == null) {
            throw new IllegalArgumentException("garage order is not valid");
        }
    }

    /**
     * Factory method to create a new GarageOrder
     * from the incoming use case / driving use case.
     * <p>
     * Factory method as a more expressive alternative to a constructor.
     *
     * @param vehicle
     * @return
     */
    public static GarageOrder createNewGarageOrder(Vehicle vehicle) {
        if (vehicle != null) {
            GarageOrder garageOrder = new GarageOrder();
            garageOrder.vehicle = vehicle;
            return garageOrder;
        }
        throw new IllegalArgumentException("vehicle is not valid");
    }
}
