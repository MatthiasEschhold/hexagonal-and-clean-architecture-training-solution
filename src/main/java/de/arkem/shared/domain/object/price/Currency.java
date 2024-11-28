package de.arkem.shared.domain.object.price;

import de.arkem.shared.domain.model.type.StringValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class Currency extends StringValueObject {

    private static Consumer<Validation<String>> constraints = Constraints.isPattern("{EUR|USD}");
    public Currency(String value) {
        super(value, constraints);
    }
}
