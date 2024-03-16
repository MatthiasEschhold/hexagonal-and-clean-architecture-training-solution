package de.arkem.clean.arc.demo.modulith.garage.order.domain.model.position;

import de.arkem.clean.arc.demo.shared.domain.model.types.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class Quantity extends DoubleValueObject {
    private static Consumer<Validation<Double>> constraints = Constraints.isGreatThanOrEqual(0.0);

    public Quantity(Double value) {
        super(value, constraints);
    }
}
