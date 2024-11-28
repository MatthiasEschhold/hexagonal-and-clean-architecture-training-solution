package de.arkem.clean.arc.demo.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.CreateVehicleResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.MileageRecordResource;
import de.arkem.clean.arc.demo.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.VehicleDbEntity;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetAllVehicles;
import de.arkem.clean.arc.demo.vehicle.usecase.in.GetVehicleByVin;
import de.arkem.clean.arc.demo.vehicle.usecase.in.UpdateMileage;
import de.arkem.clean.arc.demo.vehicle.usecase.interactor.VehicleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
class VehicleController {

    private final VehicleToResourceMapper resourceMapper;
    private final CreateVehicle createVehicle;
    private final UpdateMileage updateMileage;
    private final GetVehicleByVin getVehicle;
    private final GetAllVehicles getAllVehicles;

    public VehicleController(VehicleToResourceMapper resourceMapper, CreateVehicle createVehicle, UpdateMileage updateMileage, GetVehicleByVin getVehicle, GetAllVehicles getAllVehicles) {
        this.resourceMapper = resourceMapper;
        this.createVehicle = createVehicle;
        this.updateMileage = updateMileage;
        this.getVehicle = getVehicle;
        this.getAllVehicles = getAllVehicles;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResource>> readVehicles() {
        var vehicles = getAllVehicles.get();
        return ResponseEntity.ok(vehicles.stream().map(resourceMapper::mapVehicleToResource).toList());
    }

    @GetMapping("/{vin}")
    public ResponseEntity<VehicleResource> readVehicle(@PathVariable String vin) {
        try {
            var vehicle = getVehicle.get(new Vin(vin));
            return ResponseEntity.ok(resourceMapper.mapVehicleToResource(vehicle));
        } catch (VehicleNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody CreateVehicleResource resource) {
        try {
            var createdVehicle = createVehicle.create(new Vin(resource.getVin()),
                    new LicensePlate(resource.getLicensePlate()), new Mileage(resource.getMileage()));
            return ResponseEntity.ok(resourceMapper.mapVehicleToResource(createdVehicle));
        } catch (VehicleNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{vin}")
    public ResponseEntity<VehicleResource> updateMileage(@RequestBody MileageRecordResource resource, @PathVariable String vin) {
        try {
            var updatedVehicle = updateMileage.update(new Vin(vin), new Mileage(resource.getMileage()));
            return ResponseEntity.ok(resourceMapper.mapVehicleToResource(updatedVehicle));
        } catch (VehicleNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
