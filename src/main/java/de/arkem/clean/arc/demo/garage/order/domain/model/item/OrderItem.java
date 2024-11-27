package de.arkem.clean.arc.demo.garage.order.domain.model.item;

import de.arkem.clean.arc.demo.garage.order.domain.model.price.Price;
import de.arkem.clean.arc.demo.garage.order.domain.model.time.ExecutionTime;
import io.github.domainprimitives.object.ComposedValueObject;

public class OrderItem extends ComposedValueObject {
    private final ItemNumber itemNumber;
    private final ItemDescription itemDescription;
    private final Quantity quantity;
    private final Price netPrice;
    private final ExecutionTime executionTime;

    public OrderItem(ItemNumber itemNumber, ItemDescription itemDescription, Quantity quantity, Price netPrice, ExecutionTime executionTime) {
        this.itemNumber = itemNumber;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.netPrice = netPrice;
        this.executionTime = executionTime;
    }

    @Override
    protected void validate() {
        if(itemNumber == null || itemDescription == null || quantity == null || netPrice == null || executionTime == null) {
            throw new IllegalArgumentException("Order item could not created due to missing mandatory properties");
        }
    }
    public ItemNumber getItemNumber() {
        return itemNumber;
    }

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getNetPrice() {
        return netPrice;
    }

    public ExecutionTime getExecutionTime() {
        return executionTime;
    }
}
