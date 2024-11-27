package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ExplosionChartVehicleFindRepositoryTest {
    @Mock
    private VehicleCrudRepository vehicleCrudRepository;
    @Mock
    private VehicleToDbEntityMapper vehicleToDbEntityMapper;
    private VehicleFindRepository vehicleFindRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        vehicleFindRepository = new VehicleFindRepository(vehicleCrudRepository, vehicleToDbEntityMapper);
    }

    @Test
    void shouldReturnVehicleWhenVinExists() {
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var vehicle = VehicleTestDataFactory.createVehicle();
        var vehicleDbEntity = VehicleTestDataFactory.constructVehicleDbEntity();

        when(vehicleCrudRepository.findById(anyString())).thenReturn(Optional.of(vehicleDbEntity));
        when(vehicleToDbEntityMapper.mapVehicleDbEntityToEntity(vehicleDbEntity)).thenReturn(vehicle);

        Optional<Vehicle> result = vehicleFindRepository.findByVin(vin);

        assertThat(result).isPresent();
        assertThat(result.get().getVin().value()).isEqualTo(vin.value());
    }

    @Test
    void shouldReturnEmptyWhenVinDoesNotExist() {
        when(vehicleCrudRepository.findById(anyString())).thenReturn(Optional.empty());
        Optional<Vehicle> result = vehicleFindRepository.findByVin(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE));
        assertThat(result).isNotPresent();
    }

    @Test
    void shouldReturnEmptyWhenVinIsNull() {
        Optional<Vehicle> result = vehicleFindRepository.findByVin(null);
        assertThat(result).isNotPresent();
    }

    @Test
    void shouldReturnAllVehiclesWhenVehiclesExist() {
        var vehicleDbEntities = List.of(VehicleTestDataFactory.constructVehicleDbEntity());
        var vehicles = List.of(VehicleTestDataFactory.createVehicle());

        when(vehicleCrudRepository.findAll()).thenReturn(vehicleDbEntities);
        when(vehicleToDbEntityMapper.mapVehicleDbEntityToEntity(vehicleDbEntities.get(0))).thenReturn(vehicles.get(0));

        List<Vehicle> result = vehicleFindRepository.findAll();

        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(vehicles.size());
        assertThat(result.get(0).getVin().value()).isEqualTo(vehicles.get(0).getVin().value());
    }

    @Test
    void shouldReturnEmptyListWhenNoVehiclesExist() {
        when(vehicleCrudRepository.findAll()).thenReturn(List.of());

        List<Vehicle> result = vehicleFindRepository.findAll();

        assertThat(result).isEmpty();
    }
}