package de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle;

import io.github.domainprimitives.object.ComposedValueObject;
public class ExplosionChartVehicle extends ComposedValueObject {
    private final VehicleModel model;
    private final ConstructionYear fromConstructionYear;
    private final ConstructionYear toConstructionYear;

    public ExplosionChartVehicle(VehicleModel model, ConstructionYear fromConstructionYear, ConstructionYear toConstructionYear) {
        this.model = model;
        this.fromConstructionYear = fromConstructionYear;
        this.toConstructionYear = toConstructionYear;
    }
    @Override
    protected void validate() {
        if(model == null || fromConstructionYear == null || toConstructionYear == null) {
            throw new IllegalArgumentException("missing mandatory properties");
        }
        //example for behavior validation within the value object with the effect of changing the primitive datatype
        //without sideeffects to other code
        if(fromConstructionYear.isBefore(toConstructionYear)) {
            throw new IllegalArgumentException("fromConstructionYear must be less than toConstructionYear");
        }
    }

    public VehicleModel getModel() {
        return model;
    }

    public ConstructionYear getFromConstructionYear() {
        return fromConstructionYear;
    }

    public ConstructionYear getToConstructionYear() {
        return toConstructionYear;
    }
}
