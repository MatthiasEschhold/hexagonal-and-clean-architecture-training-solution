package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.usecase;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.BaseRingTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public abstract class BaseUseCaseRingTest extends BaseRingTest {

    protected abstract void useCaseIn_fitnessFunction(JavaClasses classes);
    protected abstract void useCaseOut_fitnessFunction(JavaClasses classes);
    protected abstract void useCaseInteractor_fitnessFunction(JavaClasses classes);

    protected BaseUseCaseRingTest(String rootEntity) {
        super(rootEntity);
    }

    protected void run_useCaseIn_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleUseCaseIn();
        rule.check(classes);
    }

    protected void run_useCaseInteractor_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleUseCaseInteractor();
        rule.check(classes);
    }

    protected void run_useCaseOut_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleUseCaseOut();
        rule.check(classes);
    }

    private ArchRule buildArchRuleUseCaseIn() {
        var useCaseInRing = buildUseCaseInRing();
        var domainModelRing = buildDomainModelRing();
        var interactorRing = buildInteractorRing();

        return classes()
                .that()
                .resideInAPackage(useCaseInRing)
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        domainModelRing, //two-way und one-way mapping
                        interactorRing, //full-mapping
                        JAVA_LANG,
                        JAVA_UTIL,
                        FRAMEWORK_STEREOTYPES);
    }

    private ArchRule buildArchRuleUseCaseOut() {
        var interactorRing = buildInteractorRing();
        var useCaseOutRing = buildUseCaseOutRing();
        var domainModelRing = buildDomainModelRing();

        return classes()
                .that()
                .resideInAPackage(useCaseOutRing)
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        interactorRing, //full-mapping
                        domainModelRing, //two-way und one-way mapping
                        JAVA_LANG,
                        JAVA_UTIL,
                        FRAMEWORK_STEREOTYPES);
    }

    private ArchRule buildArchRuleUseCaseInteractor() {
        var interactorRing = buildInteractorRing();
        var useCaseInRing = buildUseCaseInRing();
        var useCaseOutRing = buildUseCaseOutRing();
        var domainModelRing = buildDomainModelRing();
        var domainServiceRing = buildDomainServiceRing();

        return classes()
                .that()
                .resideInAPackage(interactorRing)
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        useCaseInRing,
                        useCaseOutRing,
                        interactorRing,
                        domainModelRing,
                        domainServiceRing,
                        JAVA_LANG,
                        JAVA_UTIL,
                        FRAMEWORK_STEREOTYPES);
    }

}
