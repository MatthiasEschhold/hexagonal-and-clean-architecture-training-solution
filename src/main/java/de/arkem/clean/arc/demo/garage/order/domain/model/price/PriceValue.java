package de.arkem.clean.arc.demo.garage.order.domain.model.price;

import de.arkem.shared.domain.model.types.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class PriceValue extends DoubleValueObject {
    private static Consumer<Validation<Double>> constraints = Constraints.isGreatThanOrEqual(0.1);
    public PriceValue(Double value) {
        super(value, constraints);
    }

}
