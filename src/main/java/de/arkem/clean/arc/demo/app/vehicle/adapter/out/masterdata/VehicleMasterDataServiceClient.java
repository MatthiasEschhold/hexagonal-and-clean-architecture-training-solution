package de.arkem.clean.arc.demo.app.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private final VehicleMasterDataToEntityExternalApiMapper externalApiMapper;

    public VehicleMasterDataServiceClient(VehicleMasterDataToEntityExternalApiMapper externalApiMapper) {
        this.externalApiMapper = externalApiMapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        VehicleDataDto vehicleDataDto = mockExternalServiceCall(vin.value());
        return externalApiMapper.mapVehicleMasterDataToEntity(vehicleDataDto);
    }

    private VehicleDataDto mockExternalServiceCall(String vin) {
        return new VehicleDataDto();
    }
}
