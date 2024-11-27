package de.arkem.clean.arc.demo.garage.order.domain.model;

import de.arkem.clean.arc.demo.garage.order.domain.model.item.OrderItem;
import de.arkem.clean.arc.demo.garage.order.domain.model.price.Price;
import de.arkem.clean.arc.demo.garage.order.domain.model.time.ExecutionTime;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.GarageOrderVehicle;
import io.github.domainprimitives.object.Aggregate;

import java.util.List;

public class GarageOrder extends Aggregate {
    private GarageOrderVehicle vehicle;
    private OrderNumber orderNumber;
    private List<OrderItem> items;
    private Price totalNetPrice;
    private Price totalGrossPrice;
    private ExecutionTime totalExecutionTime;
    public GarageOrder(GarageOrderVehicle vehicle) {
        this.vehicle = vehicle;
        validate();
    }

    public void addOrderPositions(List<OrderItem> orderItems) {
        this.items.addAll(orderItems);
        calculateTotalExecutionTime();
    }
    public void addOrderPositions(OrderItem orderItem) {
        this.items.add(orderItem);
        calculateTotalExecutionTime();
    }

    private void calculateTotalExecutionTime() {
        this.totalExecutionTime = new ExecutionTime(this.items.stream()
                .map(OrderItem::getExecutionTime)
                .map(ExecutionTime::getValue)
                .reduce(0, Integer::sum));
    }

    public GarageOrderVehicle getVehicle() {
        return vehicle;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Price getTotalNetPrice() {
        return totalNetPrice;
    }

    public Price getTotalGrossPrice() {
        return totalGrossPrice;
    }
    public ExecutionTime getTotalExecutionTime() {
        return totalExecutionTime;
    }

    @Override
    protected void validate() {
        if (vehicle == null) {
            throw new IllegalArgumentException("garage order is not valid");
        }
    }

}
