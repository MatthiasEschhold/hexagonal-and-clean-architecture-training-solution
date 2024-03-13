package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data;
public record CountryOfManufacture(String value) {
    private static final String CODE_OF_MANUFACTURE_PATTERN = "^[A-Z]{2}$";
    public CountryOfManufacture {
        if(!value.matches(CODE_OF_MANUFACTURE_PATTERN)) {
            throw new IllegalArgumentException("country of manufacture is not valid");
        }
    }
}
