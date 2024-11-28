package de.arkem.clean.arc.demo.modular.monolith.fitness.function.template.based;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
@AnalyzeClasses(packages = "de.arkem.clean.arc.demo",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ArchitecturePatternWithLayeredTemplate {
    @ArchTest
    void test(JavaClasses classes) {
        Architectures.LayeredArchitecture rule =
                layeredArchitecture().consideringAllDependencies()
                .layer("Vehicle").definedBy("..vehicle..")
                .layer("GarageOrder").definedBy("..garage.order..")
                .layer("ExplosionChart").definedBy("..explosion.chart..")
                .layer("SpareParts").definedBy("..spare.parts..")
                .whereLayer("Vehicle").mayOnlyBeAccessedByLayers("GarageOrder")
                .whereLayer("Vehicle").mayOnlyBeAccessedByLayers("ExplosionChart")
                .whereLayer("SpareParts").mayOnlyBeAccessedByLayers("GarageOrder")
                .whereLayer("GarageOrder").mayNotBeAccessedByAnyLayer()
                .whereLayer("SpareParts").mayNotBeAccessedByAnyLayer();
        rule.check(classes);
    }
}
