package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle;

import de.arkem.clean.arc.demo.app.common.domain.model.StringValueObject;

public record Vin(String value) {

    private static final String VIN_PATTERN = "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}";
    public Vin {
        if (value == null || !value.matches(VIN_PATTERN)) {
            throw new IllegalArgumentException("vin is not valid");
        }
    }
}
