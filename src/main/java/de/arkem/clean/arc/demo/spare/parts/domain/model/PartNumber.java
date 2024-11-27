package de.arkem.clean.arc.demo.spare.parts.domain.model;

public record PartNumber(String value) {
    public PartNumber {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("Part number must not be null or empty");
        }
    }
}
