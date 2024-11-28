package de.arkem.clean.arc.demo.modular.monolith.fitness.function.template.based;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import de.arkem.clean.arc.demo.modular.monolith.arch.unit.plugin.CleanArchitecture;
import de.arkem.clean.arc.demo.modular.monolith.arch.unit.plugin.CleanArchitectureCheck;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ArchitecturePatternWithCleanArchitectureTemplateTest {

    @ArchTest
    void clean_architecture_fitness_function(JavaClasses classes) {
        CleanArchitecture rule = CleanArchitecture.cleanArchitecture(CleanArchitectureCheck.ARCHITECTURAL_EXPRESSIVE)
                .domainModel("..domain.model..")
                .domainService("..domain.service..")
                .adapterIn("..adapter.in..")
                .adapterOut("..adapter.out..")
                .usecaseInteractor("..usecase.interactor..")
                .useCaseIn("..usecase.in..")
                .useCaseOut("..usecase.out..")
                .sharedKernel("..shared.domain.object..")
                .adapterOutOfAdapterOutUseCaseIn(
                        "..explosion.chart.adapter.out.vehicle..",
                       "..garage.order.adapter.out.vehicle..");
                //.ignore("..shared..");
                //.applicationService("..explosion.chart.usecase.interactor.load..");

        rule.check(classes);
    }
}
