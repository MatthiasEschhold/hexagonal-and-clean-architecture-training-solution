package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.usecase;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.RootEntities;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class VehicleUseCaseRingTest extends BaseUseCaseRingTest {

    public VehicleUseCaseRingTest() {
        super(RootEntities.VEHICLE);
    }

    @ArchTest
    protected void useCaseInteractor_fitnessFunction(JavaClasses classes) {
        this.run_useCaseInteractor_fitnessFunction(classes);
    }

    @ArchTest
    protected void useCaseOut_fitnessFunction(JavaClasses classes) {
        this.run_useCaseOut_fitnessFunction(classes);
    }

    @ArchTest
    protected void useCaseIn_fitnessFunction(JavaClasses classes) {
        this.run_useCaseIn_fitnessFunction(classes);
    }
}
