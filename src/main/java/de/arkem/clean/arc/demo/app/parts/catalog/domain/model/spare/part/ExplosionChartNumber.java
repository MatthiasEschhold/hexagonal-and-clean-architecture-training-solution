package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.spare.part;

import de.arkem.clean.arc.demo.app.common.domain.model.IntegerValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class ExplosionChartNumber extends IntegerValueObject {
    private static Consumer<Validation<Integer>> constraints = Constraints.isGreatThanOrEqual(1);

    public ExplosionChartNumber(Integer value) {
        super(value, constraints);
    }
}
