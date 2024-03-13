package de.arkem.clean.arc.demo.app.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.app.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.GetVehicleByVin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleToResourceApiMapper resourceMapper;
    private final CreateVehicle createVehicle;
    private final GetVehicleByVin getVehicle;

    public VehicleController(VehicleToResourceApiMapper resourceMapper, CreateVehicle createVehicle, GetVehicleByVin getVehicle) {
        this.resourceMapper = resourceMapper;
        this.createVehicle = createVehicle;
        this.getVehicle = getVehicle;
    }

    @GetMapping("/{vin}")
    public VehicleResource readVehicle(String vin) {
        Vehicle vehicle = getVehicle.get(new Vin(vin));
        return resourceMapper.mapVehicleToResource(vehicle);
    }

    @PostMapping
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehicle = createVehicle.create(new Vin(resource.getVin()),
                new LicensePlate(resource.getLicensePlate()), new Mileage(resource.getMileageRecords().get(0).getMileage()));
        return ResponseEntity.ok(resourceMapper.mapVehicleToResource(createdVehicle));
    }
}
