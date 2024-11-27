package de.arkem.clean.arc.demo.garage.order.domain.model.vehicle;

import io.github.domainprimitives.object.ComposedValueObject;

public class GarageOrderVehicle extends ComposedValueObject {
    private final LicensePlate licencePlate;
    private final  Mileage mileage;
    private final Vin vin;
    public GarageOrderVehicle(LicensePlate licencePlate, Vin vin, Mileage mileage) {
        this.licencePlate = licencePlate;
        this.vin = vin;
        this.mileage = mileage;
        validate();
    }

    @Override
    protected void validate() {
        if (licencePlate == null || vin == null || mileage == null) {
            throw new IllegalArgumentException("Garage order vehicle could not created due to missing mandatory properties");
        }
    }

    public LicensePlate getLicensePlate() {
        return licencePlate;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public Vin getVin() {
        return vin;
    }
}
