package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import de.arkem.clean.arc.demo.vehicle.usecase.out.FindVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GetAllExplosionChartVehicleInteractorTest {


    @Mock
    private FindVehicle findVehicle;

    private GetAllVehicleInteractor getAllVehicleInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        getAllVehicleInteractor = new GetAllVehicleInteractor(findVehicle);
    }

    void shouldReturnAllVehiclesWhenVehiclesExist() {
        var vehicle1 = VehicleTestDataFactory.createVehicle();
        var vehicle2 = VehicleTestDataFactory.createVehicle("WP0ZZZ99ZTS392156", "S-VK 1899");
        var vehicle3 = VehicleTestDataFactory.createVehicle("WP0ZZZ99ZTS392157", "ES-PT 0504");
        when(findVehicle.findAll()).thenReturn(List.of(vehicle1, vehicle2, vehicle3));

        List<Vehicle> result = getAllVehicleInteractor.get();

        assertThat(result).containsExactly(vehicle1, vehicle2, vehicle3);
    }

    void shouldReturnEmptyListWhenNoVehiclesExist() {
        when(findVehicle.findAll()).thenReturn(Collections.emptyList());

        List<Vehicle> result = getAllVehicleInteractor.get();

        assertThat(result).isEmpty();
    }

    void shouldReturnEmptyListWhenFindVehicleReturnsNull() {
        when(findVehicle.findAll()).thenReturn(null);

        List<Vehicle> result = getAllVehicleInteractor.get();

        assertThat(result).isNull();
    }
}