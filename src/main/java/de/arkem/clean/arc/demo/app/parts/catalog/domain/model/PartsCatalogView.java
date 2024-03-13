package de.arkem.clean.arc.demo.app.parts.catalog.domain.model;

import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.explosion.chart.ExplosionChart;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.parts.category.PartsCategory;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.spare.part.SparePart;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.spare.part.SparePartNumber;
import de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle.Vehicle;
import io.github.domainprimitives.object.Aggregate;

import java.util.ArrayList;
import java.util.List;

public class PartsCatalogView extends Aggregate {
    private final ExplosionChart explosionChart;
    private final Vehicle vehicle;
    private final List<SparePart> spareParts;
    private final List<SparePartNumber> configuredSparePartNumbers;
    private final PartsCategory partsCategory;

    public PartsCatalogView(ExplosionChart explosionChart, Vehicle vehicle, PartsCategory partsCategory, List<SparePartNumber> configuredSparePartNumbers) {
        this.explosionChart = explosionChart;
        this.vehicle = vehicle;
        this.partsCategory = partsCategory;
        this.configuredSparePartNumbers = configuredSparePartNumbers;
        this.spareParts = new ArrayList<>();
        this.validate();
    }

    @Override
    protected void validate() {
        if (explosionChart == null || vehicle == null || spareParts == null || spareParts.isEmpty() || partsCategory == null) {
            throw new IllegalArgumentException("parts catalog is not valid");
        }
    }

    public ExplosionChart getExplosionChart() {
        return explosionChart;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<SparePart> getSpareParts() {
        return spareParts;
    }

    public PartsCategory getPartsCategory() {
        return partsCategory;
    }

    public List<SparePartNumber> getConfiguredSparePartNumbers() {
        return configuredSparePartNumbers;
    }

    public void addSpareParts(List<SparePart> spareParts) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
