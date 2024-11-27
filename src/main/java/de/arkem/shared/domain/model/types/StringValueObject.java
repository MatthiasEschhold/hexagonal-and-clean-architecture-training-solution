package de.arkem.shared.domain.model.types;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public abstract class StringValueObject extends ValueObject<String> {

    private static Consumer<Validation<String>> basicContraints = Constraints.isNotNull()
            .andThen(Constraints.isNotBlank());

    /**
     * string based value object with basic constraints not null and not empty
     *
     * @param value
     */
    public StringValueObject(String value) {
        super(value, basicContraints);
    }

    /**
     * string based value object with basic constraints not null and not empty
     * as well as additional constraints
     *
     * @param value
     * @param constraints
     */
    public StringValueObject(String value, Consumer<Validation<String>> constraints) {
        super(value, basicContraints.andThen(constraints));
    }
}
