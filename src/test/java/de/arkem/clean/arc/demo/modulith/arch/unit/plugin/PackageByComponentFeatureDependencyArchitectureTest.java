package de.arkem.clean.arc.demo.modulith.arch.unit.plugin;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "de.arkem.clean.arc.demo.componentmodulith",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class PackageByComponentFeatureDependencyArchitectureTest {

    @ArchTest
    void dependency_check_for_domain_componnent_of_vehicle(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                    .resideInAPackage(
                            "..domain.vehicle.."
                    )
                .should()
                    .onlyHaveDependentClassesThat()
                    .resideInAnyPackage(
                            "..domain.vehicle..",
                            "..inbound.vehicle..",
                            "..inbound.fleet.."
                    );
        rule.check(classes);
    }

    @ArchTest
    void dependency_check_for_domain_componnent_of_fleet(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .resideInAPackage(
                        "..domain.fleet.."
                )
                .should()
                    .onlyHaveDependentClassesThat()
                    .resideInAPackage(
                        "..inbound.fleet.."
                    );
        rule.check(classes);
    }
    @ArchTest
    void dependency_check_for_domain_component_of_driver(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                    .resideInAPackage(
                        "..domain.driver.."
                    )
                .should()
                    .onlyHaveDependentClassesThat()
                    .resideInAnyPackage(
                    "..inbound.driver..",
                            "..inbound.fleet.."
                    );
        rule.check(classes);
    }

    @ArchTest
    void dependency_check_inbound_fleet_component(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .resideInAPackage(
                        "..inbound.fleet.."
                )
                .should()
                    .onlyDependOnClassesThat()
                    .resideInAnyPackage(
                    "..fleet..",
                            "..domain.vehicle..",
                            "..domain.driver..",
                            "..java.."
                    );
        rule.check(classes);
    }

    @ArchTest
    void dependency_check_inbound_vehicle_component(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .resideInAPackage(
                        "..inbound.vehicle.."
                )
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "..vehicle..",
                        "..java.."
                );
        rule.check(classes);
    }

    @ArchTest
    void dependency_check_inbound_driver_component(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .resideInAPackage(
                        "..inbound.driver.."
                )
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "..driver..",
                        "..java.."
                );
        rule.check(classes);
    }
}
