package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.domain.service.DetectRegistrationCountryService;
import de.arkem.clean.arc.demo.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.out.DetectTheftStatus;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchRiskCountries;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.vehicle.usecase.out.SaveVehicle;
import org.springframework.stereotype.Component;

@Component
class CreateVehicleInteractor implements CreateVehicle {
    private final SaveVehicle saveVehicle;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final FetchRiskCountries fetchRiskCountries;
    private final DetectTheftStatus detectTheftStatus;
    private final TheftRiskRatingService theftRiskRatingService;
    private final DetectRegistrationCountryService detectRegistrationCountryService;

    public CreateVehicleInteractor(SaveVehicle saveVehicle, FetchVehicleMasterData fetchVehicleMasterData,
                                   FetchRiskCountries fetchRiskCountries, DetectTheftStatus detectTheftStatus,
                                   TheftRiskRatingService theftRiskRatingService, DetectRegistrationCountryService detectRegistrationCountryService) {
        this.saveVehicle = saveVehicle;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.fetchRiskCountries = fetchRiskCountries;
        this.detectTheftStatus = detectTheftStatus;
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectRegistrationCountryService = detectRegistrationCountryService;
    }

    @Override
    public Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage) {

        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);

        int riskScore = theftRiskRatingService.detectRiskScore(vehicleMasterData.countryOfManufacture(),
                fetchRiskCountries.fetch(), detectRegistrationCountryService.detect(licensePlate));

        if (riskScore >= 20 && detectTheftStatus.detect(vin).value()) {
            throw new IllegalArgumentException("vehicle is stolen");
        }

        return saveVehicle.save(Vehicle.createNewVehicle(vin, licensePlate, mileage, vehicleMasterData));
    }
}
