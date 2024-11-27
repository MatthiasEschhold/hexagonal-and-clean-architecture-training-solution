package de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle;

import de.arkem.shared.domain.model.types.IntegerValueObject;

public class ConstructionYear extends IntegerValueObject {
    public ConstructionYear(Integer value) {
        super(value);
    }

    public boolean isBefore(ConstructionYear toConstructionYear) {
        if(this.getValue() <= toConstructionYear.getValue()) {
            return true;
        }
        return false;
    }
}
