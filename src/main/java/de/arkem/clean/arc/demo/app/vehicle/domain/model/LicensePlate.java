package de.arkem.clean.arc.demo.app.vehicle.domain.model;

public record LicensePlate(String value) {
    private static final String EU_LICENSE_PLATE_PATTERN = "^[A-Z]{1,3}[a-z]{0,1}[-]{0,1}[A-Z]{0,2}\\s[0-9]{1,5}(\\s){0,1}[A-Z]{0,1}[a-z]{0,2}$";
    public LicensePlate {
        validateLicensePlate(value);
    }

    private void validateLicensePlate(String value) {
        if (!isValidLicensePlate(value)) {
            throw new IllegalArgumentException("license plate is not valid");
        }
    }

    private boolean isValidLicensePlate(String value) {
        return value != null && value.matches(EU_LICENSE_PLATE_PATTERN);
    }

}
