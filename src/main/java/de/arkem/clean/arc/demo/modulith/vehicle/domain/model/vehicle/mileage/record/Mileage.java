package de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle.mileage.record;

public record Mileage(double value) {
    public Mileage {
        validateMileage(value);
    }

    private void validateMileage(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("mileage is not valid");
        }
    }
}
