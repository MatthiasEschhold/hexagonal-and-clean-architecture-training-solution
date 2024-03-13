package de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle;

import de.arkem.clean.arc.demo.app.common.domain.model.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class Mileage extends DoubleValueObject {
    private static Consumer<Validation<Double>> constraints = Constraints.isGreatThanOrEqual(0.0);

    public Mileage(Double value) {
        super(value, constraints);
    }
}
