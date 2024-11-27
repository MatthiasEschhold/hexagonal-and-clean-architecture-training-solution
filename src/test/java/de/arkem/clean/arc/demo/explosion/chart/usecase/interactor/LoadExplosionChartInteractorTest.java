package de.arkem.clean.arc.demo.explosion.chart.usecase.interactor;

import de.arkem.clean.arc.demo.explosion.chart.usecase.interactor.load.LoadExplosionChartInteractor;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FetchSpareParts;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.explosion.chart.usecase.out.FindExplosionChart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoadExplosionChartInteractorTest {
    private LoadExplosionChartInteractor interactor;
    private FindExplosionChart findExplosionChart;
    private FetchVehicle fetchVehicle;
    private FetchSpareParts fetchSpareParts;
    @BeforeEach
    void setUp() {
        findExplosionChart = Mockito.mock(FindExplosionChart.class);
        fetchVehicle = Mockito.mock(FetchVehicle.class);
        fetchSpareParts = Mockito.mock(FetchSpareParts.class);
        interactor = new LoadExplosionChartInteractor(findExplosionChart, fetchVehicle,fetchSpareParts);
    }

    @Test
     void shouldLoadExplosionChartSuccessfully() {
//        ExplosionChart expectedChart = createExplosionChart();
//
//        var mainCategory = createCategoryNumber(11);
//        var subCategory = createCategoryNumber(42);
//        var vehicle = createVehicle();
//
//        Mockito.when(fetchVehicle.fetch(VehicleTestDataFactory.VIN_TEST_VALUE))
//                .thenReturn(vehicle);
//
//        Mockito.when(findExplosionChart.find(mainCategory, subCategory, vehicle))
//                .thenReturn(Optional.of(expectedChart));
//
//        ExplosionChart result = interactor.load(mainCategory, subCategory, vehicle);
//        assertThat(result.getName()).isEqualTo(expectedChart.getName());
//        assertThat(result.getMainCategory()).isEqualTo(expectedChart.getMainCategory());
//        assertThat(result.getSubCategory()).isEqualTo(expectedChart.getSubCategory());
//        assertThat(result.getVehicle().getModel()).isEqualTo(expectedChart.getVehicle().getModel());
//        assertThat(result.getVehicle().getConstructionYear().getValue()).isEqualTo(expectedChart.getVehicle().getConstructionYear().getValue());
    }

    @Test
    void shouldThrowWhenExplosionNotExists() {

//        var mainCategory = createCategoryNumber(11);
//        var subCategory = createCategoryNumber(42);
//        var vehicle = createVehicle();
//
//        Mockito.when(findExplosionChart.find(mainCategory, subCategory, vehicle))
//                .thenReturn(Optional.empty());
//
//        assertThrows(ExplosionChartNotFoundException.class, () -> interactor.load(mainCategory, subCategory, vehicle));
    }

}