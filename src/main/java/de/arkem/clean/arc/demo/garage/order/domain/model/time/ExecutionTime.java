package de.arkem.clean.arc.demo.garage.order.domain.model.time;

import de.arkem.shared.domain.model.types.IntegerValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class ExecutionTime extends IntegerValueObject {

    private static Consumer<Validation<Integer>> constraints = Constraints.isGreatThanOrEqual(1);

    public ExecutionTime(Integer value) {
        super(value, constraints);
    }
}
