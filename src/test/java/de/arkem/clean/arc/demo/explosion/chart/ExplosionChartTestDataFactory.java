package de.arkem.clean.arc.demo.explosion.chart;

import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartId;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ChartName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.SparePartNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.Category;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryName;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.CategoryNumber;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.category.PartsCategory;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ConstructionYear;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.ExplosionChartVehicle;
import de.arkem.clean.arc.demo.explosion.chart.domain.model.vehicle.VehicleModel;

import java.util.List;

public class ExplosionChartTestDataFactory {

    public static final String SPARE_PART_NUMBER_1 = "11 42 7 537 293";
    public static final String SPARE_PART_NUMBER_2 = "11 42 7 538 157";
    public static final String SPARE_PART_NUMBER_3 = "11 42 7 538 158";
    private static final String SPARE_PART_NAME_1 = "Front Bumper";
    private static final String SPARE_PART_NAME_2 = "Front Light";
    private static final String SPARE_PART_NAME_3 = "Stabilisator Bracket Pack";

    public static ExplosionChart createExplosionChart() {
        var chartName = new ChartName("Front for 2012 BMW 328i");
        var mainCategory = new Category(new CategoryName("Front"),createCategoryNumber(11));
        var subCategory = new Category(new CategoryName("Bumper"), createCategoryNumber(42));
        var vehicle = createVehicle();
        return new ExplosionChart(new ChartId(123), chartName, new PartsCategory(mainCategory, subCategory), vehicle, createSparePartNumbers());
    }

    private static List<SparePartNumber> createSparePartNumbers() {
        return List.of(
                createSparePartNumber(SPARE_PART_NUMBER_1),
                createSparePartNumber(SPARE_PART_NUMBER_2),
                createSparePartNumber(SPARE_PART_NUMBER_3)
        );
    }

    public static ExplosionChartVehicle createVehicle() {
        return new ExplosionChartVehicle(new VehicleModel("BMW 328i"), new ConstructionYear(2010), new ConstructionYear(2012));
    }

    public static CategoryNumber createCategoryNumber(int number) {
        var mainCategory = new CategoryNumber(number);
        return mainCategory;
    }

    public static SparePartNumber createSparePartNumber(String number) {
        return new SparePartNumber(number);
    }
}
