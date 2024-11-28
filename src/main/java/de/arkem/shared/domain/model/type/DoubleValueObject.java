package de.arkem.shared.domain.model.type;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public abstract class DoubleValueObject extends ValueObject<Double> {

    private static Consumer<Validation<Double>> basicContraints = Constraints.isNotNullDouble();

    public DoubleValueObject(Double value) {
        super(value, basicContraints);
    }

    public DoubleValueObject(Double value, Consumer<Validation<Double>> constraints) {
        super(value, basicContraints.andThen(constraints));
    }
}
