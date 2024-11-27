package de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data;

public record ConstructionYear(Integer value) {
    public ConstructionYear {
        if (value == null) {
            throw new IllegalArgumentException("ConstructionYear could not created due to missing mandatory properties");
        }
    }
}
