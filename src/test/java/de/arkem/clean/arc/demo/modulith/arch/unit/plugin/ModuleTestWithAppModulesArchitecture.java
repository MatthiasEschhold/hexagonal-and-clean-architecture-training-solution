package de.arkem.clean.arc.demo.modulith.arch.unit.plugin;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.modules.syntax.ModulesByAnnotationRule;
import de.arkem.shared.domain.model.types.AppModule;

import static com.tngtech.archunit.library.modules.syntax.ModuleDependencyScope.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.modules.syntax.ModuleRuleDefinition.modules;

@AnalyzeClasses(packages = "de.arkem.clean.arc.demo.modulith",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ModuleTestWithAppModulesArchitecture {
    @ArchTest
    void domain_modules_should_respect_rules_for_vertical_features(JavaClasses classes) {
        ModulesByAnnotationRule rule = modules()
            .definedByAnnotation(AppModule.class)
            .should()
                .respectTheirAllowedDependenciesDeclaredIn("allowedDependencies",
                        consideringOnlyDependenciesInAnyPackage("..modulith.."))
            .andShould()
                .onlyDependOnEachOtherThroughPackagesDeclaredIn("exposedPackages");
        rule.check(classes);
    }
}
