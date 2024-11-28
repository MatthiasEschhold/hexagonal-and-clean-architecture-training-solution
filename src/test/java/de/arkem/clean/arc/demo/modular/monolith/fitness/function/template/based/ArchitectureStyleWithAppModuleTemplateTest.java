package de.arkem.clean.arc.demo.modular.monolith.fitness.function.template.based;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.modules.syntax.ModulesByAnnotationRule;
import de.arkem.shared.domain.model.type.AppModule;

import static com.tngtech.archunit.library.modules.syntax.ModuleDependencyScope.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.modules.syntax.ModuleRuleDefinition.modules;

@AnalyzeClasses(packages = "de.arkem",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ArchitectureStyleWithAppModuleTemplateTest {
    @ArchTest
    void domain_modules_should_respect_rules_for_vertical_features(JavaClasses classes) {
        ModulesByAnnotationRule<AppModule> rule = modules()
            .definedByAnnotation(AppModule.class)
            .should()
                .respectTheirAllowedDependenciesDeclaredIn("allowedDependencies",
                        consideringOnlyDependenciesInAnyPackage("..de.arkem.."))
            .andShould()
                .onlyDependOnEachOtherThroughPackagesDeclaredIn("exposedPackages");
        rule.check(classes);
    }
}
