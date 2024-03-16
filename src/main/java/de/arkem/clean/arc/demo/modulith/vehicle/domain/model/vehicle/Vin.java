package de.arkem.clean.arc.demo.modulith.vehicle.domain.model.vehicle;

public record Vin(String value) {

    private static final String VIN_PATTERN = "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}";
    public Vin {
        if (value == null || !value.matches(VIN_PATTERN)) {
            throw new IllegalArgumentException("vin is not valid");
        }
    }
}
