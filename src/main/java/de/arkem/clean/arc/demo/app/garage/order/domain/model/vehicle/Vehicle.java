package de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import io.github.domainprimitives.object.ComposedValueObject;

public class Vehicle extends ComposedValueObject {
    LicensePlate licencePlate;
    Mileage mileage;
    Vin vin;

    public Vehicle(LicensePlate licencePlate, Mileage mileage) {
        this.licencePlate = licencePlate;
        this.mileage = mileage;
        validate();
    }

    @Override
    protected void validate() {
        if (licencePlate == null) {
            throw new IllegalArgumentException("licencePlate is required");
        }
        if (mileage == null) {
            throw new IllegalArgumentException("mileage is required");
        }
        if (vin == null) {
            throw new IllegalArgumentException("vin is required");
        }
    }

    public LicensePlate getLicencePlate() {
        return licencePlate;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public Vin getVin() {
        return vin;
    }
}
