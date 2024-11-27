package de.arkem.clean.arc.demo.spare.parts.domain.model;

public record ManufacturerCode(String value) {
    public ManufacturerCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Manufacturer code must not be null or empty");
        }
    }
}
