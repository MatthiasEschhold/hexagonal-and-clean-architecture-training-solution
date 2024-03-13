package de.arkem.clean.arc.demo.app.aufgabe2.vehicle.usecase.interactor;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.app.aufgabe2.vehicle.usecase.out.SaveVehicle;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out.DetectTheftStatus;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out.FetchRiskCountries;
import de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.LicensePlate;

public class CreateVehicleInteractor implements CreateVehicle {
    private final SaveVehicle saveVehicle;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final FetchRiskCountries fetchRiskCountries;
    private final DetectTheftStatus detectTheftStatus;
    private final TheftRiskRatingService theftRiskRatingService;

    public CreateVehicleInteractor(SaveVehicle saveVehicle, FetchVehicleMasterData fetchVehicleMasterData,
                                   FetchRiskCountries fetchRiskCountries, DetectTheftStatus detectTheftStatus,
                                   TheftRiskRatingService theftRiskRatingService) {
        this.saveVehicle = saveVehicle;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.fetchRiskCountries = fetchRiskCountries;
        this.detectTheftStatus = detectTheftStatus;
        this.theftRiskRatingService = theftRiskRatingService;
    }
    @Override
    public Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage) {

        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);

        int riskScore = theftRiskRatingService.detectRiskScore(vehicleMasterData.countryOfManufacture(),
                fetchRiskCountries.fetch(), licensePlate);

        if(riskScore >= 20) {
            if(detectTheftStatus.detect(vin).value().equals("STOLEN")) {
                throw new IllegalArgumentException("vehicle is stolen");
            }
        }

        return saveVehicle.save(new Vehicle(vin, licensePlate, mileage, vehicleMasterData));
    }
}
