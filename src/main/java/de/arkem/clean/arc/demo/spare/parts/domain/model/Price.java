package de.arkem.clean.arc.demo.spare.parts.domain.model;

public record Price(double value) {
    public Price {
        if (value < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
        }
    }
}
