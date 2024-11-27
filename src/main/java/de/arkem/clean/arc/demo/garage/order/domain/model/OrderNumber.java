package de.arkem.clean.arc.demo.garage.order.domain.model;

import de.arkem.shared.domain.model.types.IntegerValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class OrderNumber extends IntegerValueObject {
    public OrderNumber(Integer value) {
        super(value);
    }
}
