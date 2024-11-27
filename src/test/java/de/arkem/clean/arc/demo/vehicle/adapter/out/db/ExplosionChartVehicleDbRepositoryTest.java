package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

class ExplosionChartVehicleDbRepositoryTest {

    VehicleDbRepository repositoryUnderTest;
    VehicleToDbEntityMapper mapper;
    VehicleCrudRepository vehicleCrudRepository;

    @BeforeEach
    void setUp() {
        vehicleCrudRepository = Mockito.mock(VehicleCrudRepository.class);
        mapper = Mockito.mock(VehicleToDbEntityMapper.class);
        repositoryUnderTest = new VehicleDbRepository(mapper, vehicleCrudRepository);
    }

    @Test
    void shouldSaveVehicle() {
        var vehicleDbEntityToSave = VehicleTestDataFactory.constructVehicleDbEntity();
        var vehicleToSave = VehicleTestDataFactory.createVehicle();

        when(mapper.mapVehicleToDbEntity(vehicleToSave)).thenReturn(vehicleDbEntityToSave);
        when(vehicleCrudRepository.save(vehicleDbEntityToSave)).thenReturn(vehicleDbEntityToSave);
        when(mapper.mapVehicleDbEntityToEntity(vehicleDbEntityToSave)).thenReturn(vehicleToSave);

        var savedVehicle = repositoryUnderTest.save(vehicleToSave);
        assertThat(savedVehicle, Matchers.notNullValue());
    }
}