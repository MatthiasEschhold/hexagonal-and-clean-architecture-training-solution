package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record;

public record Mileage(double value) {
    public Mileage {
        validateMileage(value);
    }

    private void validateMileage(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("kilometerstand is not valid");
        }
    }
}
