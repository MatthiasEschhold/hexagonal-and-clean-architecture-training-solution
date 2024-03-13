package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.spare.part;

import io.github.domainprimitives.object.ComposedValueObject;

public class SparePart extends ComposedValueObject {
    private final SparePartNumber sparePartNumber;
    private final SparePartName sparePartName;
    private final Price price;

    private final ExplosionChartNumber explosionChartNumber;

    public SparePart(SparePartNumber sparePartNumber, SparePartName sparePartName, Price price, ExplosionChartNumber explosionChartNumber) {
        this.sparePartNumber = sparePartNumber;
        this.sparePartName = sparePartName;
        this.price = price;
        this.explosionChartNumber = explosionChartNumber;
    }

    public SparePartNumber getSparePartNumber() {
        return sparePartNumber;
    }

    public SparePartName getSparePartName() {
        return sparePartName;
    }

    public Price getPrice() {
        return price;
    }

    public ExplosionChartNumber getExplosionChartNumber() {
        return explosionChartNumber;
    }

    @Override
    protected void validate() {
        if (sparePartNumber == null) {
            throw new IllegalArgumentException("sparePartNumber is required");
        }
        if (sparePartName == null) {
            throw new IllegalArgumentException("sparePartName is required");
        }
        if (price == null) {
            throw new IllegalArgumentException("price is required");
        }
        if (explosionChartNumber == null) {
            throw new IllegalArgumentException("explosionChartNumber is required");
        }
    }
}
