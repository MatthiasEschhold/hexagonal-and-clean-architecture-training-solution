package de.arkem.clean.arc.demo.modulith.arch.unit.plugin;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
@AnalyzeClasses(packages = "de.arkem.clean.arc.demo.modulith",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ModuleTestWithLayeredArchitecture {
    @ArchTest
    void test(JavaClasses classes) {
        Architectures.LayeredArchitecture rule =
                layeredArchitecture().consideringAllDependencies()
                .layer("Poolfahrzeug").definedBy("..vehicle..")
                .layer("GarageOrder").definedBy("..parts.catalog..")
                .layer("PartsCatalog").definedBy("..garage.order..")
                .whereLayer("Poolfahrzeug").mayOnlyBeAccessedByLayers("GarageOrder")
                .whereLayer("GarageOrder").mayOnlyBeAccessedByLayers("GarageOrder")
                .whereLayer("PartsCatalog").mayNotBeAccessedByAnyLayer();
        rule.check(classes);
    }
}
