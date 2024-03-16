package de.arkem.clean.arc.demo.modulith.parts.catalog.domain.model.spare.part;

import de.arkem.clean.arc.demo.shared.domain.model.types.StringValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class SparePartNumber extends StringValueObject {
    private static Consumer<Validation<String>> constraints = Constraints.isPattern("^[0-9]{2}-[A-Z]{3}[0-9]{8}$");

    public SparePartNumber(String value) {
        super(value);
    }
}
