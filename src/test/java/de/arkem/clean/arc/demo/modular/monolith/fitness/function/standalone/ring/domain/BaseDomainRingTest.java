package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.domain;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring.BaseRingTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public abstract class BaseDomainRingTest extends BaseRingTest {

    protected abstract void domainModel_fitnessFunction(JavaClasses classes);
    protected abstract void domainService_fitnessFunction(JavaClasses classes);

    protected BaseDomainRingTest(String rootEntity) {
        super(rootEntity);
    }

    protected void run_domainModel_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleDomainModel();
        rule.check(classes);
    }

    protected void run_domainService_fitnessFunction(JavaClasses classes) {
        var rule = buildArchRuleDomainService();
        rule.check(classes);
    }

    protected ArchRule buildArchRuleDomainModel() {
        var domainModelRing = buildDomainModelRing();
        return classes()
                .that()
                .resideInAPackage(domainModelRing)
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        "..shared.domain.model.types..",
                        SHARED_DOMAIN_OBJECTS,
                        "..io.github.domainprimitives..",
                        domainModelRing,
                        JAVA_LANG,
                        JAVA_UTIL,
                        JAVA_TIME);
    }

    protected ArchRule buildArchRuleDomainService() {
        var domainServiceRing = buildDomainServiceRing();
        var domainModelRing = buildDomainModelRing();

        return classes()
                .that()
                .resideInAPackage(domainServiceRing)
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        domainModelRing,
                        domainServiceRing,
                        JAVA_LANG,
                        JAVA_UTIL,
                        JAVA_TIME);
    }
}
