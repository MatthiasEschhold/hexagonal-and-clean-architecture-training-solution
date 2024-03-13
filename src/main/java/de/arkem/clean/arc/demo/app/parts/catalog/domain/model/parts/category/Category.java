package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.parts.category;

import io.github.domainprimitives.object.ComposedValueObject;

public class Category extends ComposedValueObject {
    private final CategoryName name;
    private final CategoryNumber number;

    public Category(CategoryName name, CategoryNumber number) {
        this.name = name;
        this.number = number;
        this.validate();
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryNumber getNumber() {
        return number;
    }

    @Override
    protected void validate() {
        if (name == null) {
            throw new IllegalArgumentException("name is required");
        }
        if (number == null) {
            throw new IllegalArgumentException("number is required");
        }
    }
}
