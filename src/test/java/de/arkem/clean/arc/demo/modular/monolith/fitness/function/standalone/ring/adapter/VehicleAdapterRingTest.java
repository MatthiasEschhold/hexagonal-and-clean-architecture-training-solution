package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.adapter;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.RootEntities;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class VehicleAdapterRingTest extends BaseAdapterRingTest {

    public VehicleAdapterRingTest() {
        super(RootEntities.VEHICLE);
    }

    @ArchTest
    @Override
    protected void adapterIn_fitnessFunction(JavaClasses classes) {
        run_adapterIn_fitnessFunction(classes);
    }

    @ArchTest
    @Override
    protected void adapterOut_fitnessFunction(JavaClasses classes) {
        run_adapterOut_fitnessFunction(classes);
    }
}
