package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.usecase.in.UpdateMileage;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.out.SaveVehicle;
import org.springframework.stereotype.Component;

@Component
class UpdateMileageInteractor implements UpdateMileage {
    private final SaveVehicle saveVehicle;
    private final FindVehicle findVehicle;

    public UpdateMileageInteractor(SaveVehicle saveVehicle, FindVehicle findVehicle) {
        this.saveVehicle = saveVehicle;
        this.findVehicle = findVehicle;
    }

    /**
     * Alternative: Statement, dass das setzen direkt über ein
     * SQL-Statement erfolgt. Bedingt dann z.B. Domain Service für Prüfung des Kilometerstand-Wertes.
     * Auch das Erfassungsdatum muss im Interactor erstellt werden und in das SQL-Statement integriert werden
     * <p>
     * Update the kilometerstand of a vehicle
     *
     * @param vin     the vehicle identification number
     * @param mileage the new kilometerstand
     */
    @Override
    public Vehicle update(Vin vin, Mileage mileage) {
        Vehicle vehicle = findVehicle.findByVin(vin)
                .orElseThrow(() -> new VehicleNotFoundException(vin.value(), this.getClass().getName()));
        vehicle.updateMileage(mileage);
        return saveVehicle.save(vehicle);
    }
}
