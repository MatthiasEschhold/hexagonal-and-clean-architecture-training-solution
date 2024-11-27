package de.arkem.clean.arc.demo.garage.order.adapter.in;

import de.arkem.clean.arc.demo.garage.order.adapter.in.entity.GarageOrderResource;
import de.arkem.clean.arc.demo.garage.order.adapter.in.entity.VehicleResource;
import de.arkem.clean.arc.demo.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.garage.order.usecase.in.GarageOrderCommand;
import de.arkem.clean.arc.demo.garage.order.usecase.in.GarageOrderQuery;
import de.arkem.clean.arc.demo.garage.order.usecase.interactor.command.CreateGarageOrderCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garageorder")
public class GarageOrderController {

    private final GarageOrderCommand garageOrderCommand;
    private final GarageOrderQuery garageOrderQuery;
    private final GarageOrderResourceToDomainMapper mapper;

    public GarageOrderController(GarageOrderCommand garageOrderCommand, GarageOrderQuery garageOrderQuery, GarageOrderResourceToDomainMapper mapper) {
        this.garageOrderCommand = garageOrderCommand;
        this.garageOrderQuery = garageOrderQuery;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarageOrderResource> create(@PathVariable("id") int id) {
        var garageOrder = garageOrderQuery.read(new OrderNumber(id));
        return ResponseEntity.ok(mapper.mapToResource(garageOrder));
    }

    @PostMapping
    public ResponseEntity<GarageOrderResource> create(@RequestBody VehicleResource resource) {
        var garageOrder = garageOrderCommand.create(new CreateGarageOrderCommand(new LicensePlate(resource.getLicensePlate())));
        return ResponseEntity.ok(mapper.mapToResource(garageOrder));
    }
}
