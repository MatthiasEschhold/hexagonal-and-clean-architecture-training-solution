package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.parts.category;

import io.github.domainprimitives.object.ComposedValueObject;

public class PartsCategory extends ComposedValueObject {
    private final Category mainCategory;
    private final Category subCategory;

    public PartsCategory(Category mainCategory, Category subCategory) {
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.validate();
    }

    public Category getMainCategory() {
        return mainCategory;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    @Override
    protected void validate() {
        if (mainCategory == null) {
            throw new IllegalArgumentException("mainCategory is not valid");
        }
        if (subCategory == null) {
            throw new IllegalArgumentException("subCategory is not valid");
        }
    }
}
