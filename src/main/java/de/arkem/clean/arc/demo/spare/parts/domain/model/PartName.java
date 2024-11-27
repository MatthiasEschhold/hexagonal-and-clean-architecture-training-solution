package de.arkem.clean.arc.demo.spare.parts.domain.model;

public record PartName(String value) {
    public PartName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Part name must not be null or empty");
        }
    }
}
