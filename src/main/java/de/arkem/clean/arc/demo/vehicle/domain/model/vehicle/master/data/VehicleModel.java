package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data;

public record VehicleModel(String value) {
    public VehicleModel {
        if (value == null) {
            throw new IllegalArgumentException("VehicleModel must not be null");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("VehicleModel must not be blank");
        }
    }
}
