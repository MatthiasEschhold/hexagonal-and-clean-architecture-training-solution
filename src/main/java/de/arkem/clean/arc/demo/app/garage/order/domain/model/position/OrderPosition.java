package de.arkem.clean.arc.demo.app.garage.order.domain.model.position;

import io.github.domainprimitives.object.ComposedValueObject;

public class OrderPosition extends ComposedValueObject {

    private final PositionNumber positionNumber;
    private final PositionDescription positionDescription;

    private final Quantity quantity;

    public OrderPosition(PositionNumber positionNumber, PositionDescription positionDescription, Quantity quantity) {
        this.positionNumber = positionNumber;
        this.positionDescription = positionDescription;
        this.quantity = quantity;
    }


    @Override
    protected void validate() {
        if (positionNumber == null) {
            throw new IllegalArgumentException("positionNumber is not valid");
        }
        if (positionDescription == null) {
            throw new IllegalArgumentException("positionDescription is not valid");
        }
        if (quantity == null) {
            throw new IllegalArgumentException("quantity is not valid");
        }
    }

    public PositionNumber getPositionNumber() {
        return positionNumber;
    }

    public PositionDescription getPositionDescription() {
        return positionDescription;
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
