package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.*;

public class CreateVehicleInteractor implements CreateVehicle {
    private final SaveVehicle saveVehicle;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final FetchRiskCountries fetchRiskCountries;
    private final DetectTheftStatus detectTheftStatus;
    private final TheftRiskRatingService theftRiskRatingService;
    private final DetectRegistrationCountry detectRegistrationCountry;

    public CreateVehicleInteractor(SaveVehicle saveVehicle, FetchVehicleMasterData fetchVehicleMasterData,
                                   FetchRiskCountries fetchRiskCountries, DetectTheftStatus detectTheftStatus,
                                   TheftRiskRatingService theftRiskRatingService, DetectRegistrationCountry detectRegistrationCountry) {
        this.saveVehicle = saveVehicle;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.fetchRiskCountries = fetchRiskCountries;
        this.detectTheftStatus = detectTheftStatus;
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectRegistrationCountry = detectRegistrationCountry;
    }

    @Override
    public Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage) {

        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);

        int riskScore = theftRiskRatingService.detectRiskScore(vehicleMasterData.countryOfManufacture(),
                fetchRiskCountries.fetch(), detectRegistrationCountry.detect(licensePlate));

        if (riskScore >= 20 && detectTheftStatus.detect(vin).value().equals("STOLEN")) {
            throw new IllegalArgumentException("vehicle is stolen");
        }

        return saveVehicle.save(new Vehicle(vin, licensePlate, mileage, vehicleMasterData));
    }
}
