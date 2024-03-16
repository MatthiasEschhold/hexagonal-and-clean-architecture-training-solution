package de.arkem.clean.arc.demo.shared.domain.model.types;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public abstract class IntegerValueObject extends ValueObject<Integer> {

    private static Consumer<Validation<Integer>> basicContraints = Constraints.isNotNullInteger();

    public IntegerValueObject(Integer value) {
        super(value, basicContraints);
    }

    public IntegerValueObject(Integer value, Consumer<Validation<Integer>> constraints) {
        super(value, basicContraints.andThen(constraints));
    }
}
