package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.domain;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.RootEntities;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class SparePartsDomainRingTest extends BaseDomainRingTest {

    public SparePartsDomainRingTest() {
        super(RootEntities.SPARE_PARTS);
    }

    @ArchTest
    @Override
    protected void domainModel_fitnessFunction(JavaClasses classes) {
        run_domainModel_fitnessFunction(classes);
    }

    @ArchIgnore
    @ArchTest
    @Override
    protected void domainService_fitnessFunction(JavaClasses classes) {
        run_domainService_fitnessFunction(classes);
    }
}
