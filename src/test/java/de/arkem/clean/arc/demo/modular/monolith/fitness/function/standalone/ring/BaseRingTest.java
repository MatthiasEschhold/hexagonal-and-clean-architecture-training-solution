package de.arkem.clean.arc.demo.modular.monolith.fitness.function.standalone.ring;

public abstract class BaseRingTest {

    protected final static String JAVA_LANG = "..java.lang..";
    protected final static String JAVA_UTIL = "..java.util..";
    protected final static String FRAMEWORK_STEREOTYPES = "..org.springframework.stereotype..";
    protected static final String JAVA_TIME = "..java.time..";
    protected static final String SHARED_DOMAIN_OBJECTS = "..shared.domain.object..";

    protected String rootEntity;

    protected String buildRing(String ringName) {
        return String.format("..%s.%s..", rootEntity, ringName);
    }

    protected BaseRingTest(String rootEntity) {
        this.rootEntity = rootEntity;
    }

    protected String buildUseCaseInRing() {
        return buildRing("usecase.in");
    }

    protected String buildDomainModelRing() {
        return buildRing("domain.model");
    }

    protected String buildUseCaseOutRing() {
        return buildRing("usecase.out");
    }

    protected String buildInteractorRing() {
        return buildRing("usecase.interactor");
    }

    protected String buildDomainServiceRing() {
        return buildRing("domain.service");
    }

    protected String buildAdapterOutRing() {
        return buildRing("adapter.out");
    }

    protected String buildAdapterInRing() {
        return buildRing("adapter.in");
    }
}
