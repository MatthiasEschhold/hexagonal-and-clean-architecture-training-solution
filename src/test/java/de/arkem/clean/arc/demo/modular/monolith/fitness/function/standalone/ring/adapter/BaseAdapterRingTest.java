package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.adapter;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.BaseRingTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public abstract class BaseAdapterRingTest extends BaseRingTest {

    private static final String FRAMEWORK = "..org.springframework..";
    private static final String MAP_STRUCT = "..mapstruct..";
    private static final String PERSISTENCE = "..jakarta.persistence..";
    private static final String JAVAX_ANNOTATION_PROCESSING = "..javax.annotation.processing..";
    private static final String AZURE_JDK = "..com.azure.messaging..";

    protected abstract void adapterIn_fitnessFunction(JavaClasses classes);
    protected abstract void adapterOut_fitnessFunction(JavaClasses classes);

    protected BaseAdapterRingTest(String rootEntity) {
        super(rootEntity);
    }

    protected void run_adapterIn_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleAdapterIn();
        rule.check(classes);
    }

    protected void run_adapterOut_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleAdapterOut();
        rule.check(classes);
    }

    protected ArchRule buildArchRuleAdapterIn() {
        return classes()
                .that()
                .resideInAPackage(buildAdapterInRing())
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        buildUseCaseInRing(),
                        buildAdapterInRing(),
                        buildDomainModelRing(),
                        buildInteractorRing(), //full-mapping strategy
                        JAVA_LANG,
                        JAVA_UTIL,
                        FRAMEWORK,
                        MAP_STRUCT,
                        PERSISTENCE,
                        JAVAX_ANNOTATION_PROCESSING,
                        JAVA_TIME,
                        SHARED_DOMAIN_OBJECTS,
                        AZURE_JDK);
    }

    protected ArchRule buildArchRuleAdapterOut() {
        return classes()
                .that()
                .resideInAPackage(buildAdapterOutRing())
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        buildDomainModelRing(),
                        buildUseCaseOutRing(),
                        buildAdapterOutRing(),
                        buildInteractorRing(), // full-mapping strategy, ermöglicht aber verletzungen
                        JAVA_LANG,
                        JAVA_UTIL,
                        FRAMEWORK,
                        MAP_STRUCT,
                        PERSISTENCE,
                        JAVAX_ANNOTATION_PROCESSING,
                        JAVA_TIME,
                        SHARED_DOMAIN_OBJECTS,
                        AZURE_JDK);
    }
}
