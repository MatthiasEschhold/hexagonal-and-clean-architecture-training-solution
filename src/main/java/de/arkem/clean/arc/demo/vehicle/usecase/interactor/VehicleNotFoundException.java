package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String vin) {
        super(createMessage(vin));
    }

    public VehicleNotFoundException(String vin, String usecase) {
        super(String.format("%s within usecase %s", createMessage(vin), usecase));
    }

    private static String createMessage(String vin) {
        return String.format("ExplosionChartVehicle with VIN %s not found", vin);
    }
}
