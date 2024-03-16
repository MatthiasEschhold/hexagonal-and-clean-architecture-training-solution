package de.arkem.clean.arc.demo.modulith.garage.order.domain.model;

import de.arkem.clean.arc.demo.shared.domain.model.types.StringValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class OrderNumber extends StringValueObject {
    private static Consumer<Validation<String>> constraints =
            Constraints.isPattern("^[0-9]{4}-[a-z]{4}-[0-9]{2}$");

    public OrderNumber(String value) {
        super(value, constraints);
    }
}
