package de.arkem.clean.arc.demo.garage.order.domain.model.vehicle;

import de.arkem.shared.domain.model.type.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class Mileage extends DoubleValueObject {
    private static Consumer<Validation<Double>> constraints = Constraints.isGreatThanOrEqual(0.0);

    public Mileage(Double value) {
        super(value, constraints);
    }
}
