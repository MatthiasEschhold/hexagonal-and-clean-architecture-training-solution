package de.arkem.clean.arc.demo.modular.monolith.arch.unit.plugin;

import com.tngtech.archunit.PublicAPI;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.EvaluationResult;
import com.tngtech.archunit.library.Architectures;

import java.util.*;

public final class CleanArchitecture implements ArchRule {

    private static final String DOMAIN_MODEL = "domain.model";
    private static final String DOMAIN_SERVICE = "domain.service";
    private static final String USECASE_INTERACTOR = "usecase.interactor";
    private static final String ADAPTER_OUT = "adapter.out";
    private static final String ADAPTER_IN = "adapter.in";
    private static final String USECASE_IN = "usecase.in";
    private static final String USECASE_OUT = "usecase.out";
    private static final String DOMAIN = "domain";
    private static final String USECASE = "usecase";
    private static final String ADAPTER = "adapter";
    public static final String IGNORED_PACKAGES = "ignored.packages";
    //dependency patterns
    private static final String SHARED_KERNEL_PATTERN = "shared.kernel";
    private static final String SHARED_OUTPUT_ADAPTER_PATTERN = "shared.output.adapter";
    private static final String SUPPORTING_SERVICE_PATTERN = "supporting.service";
    private static final String EVENTS_PATTERN = "events";
    private static final String ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN = "adapter.out.usecase.in";
    private static final String APPLICATION_SERVICE_PATTERN = "application.service";
    private Optional<String> overriddenDescription;

    private String domainModelPackageIdentifier;
    private String domainServicePackageIdentifier;
    private String usecaseInteractorPackageIdentifier;
    private String adapterInPackageIdentifier;
    private String adapterOutPackageIdentifier;
    private String useCaseInPackageIdentifier;
    private String useCaseOutPackageIdentifier;

    private String useCasePackageIdentifier;
    private String adapterPackageIdentifier;
    private String domainPackageIdentifier;
    private Map<String, String> adapterPackageIdentifiers;

    //dependency
    private List<String> sharedOutputAdapter;
    private List<String> supportingService;
    private List<String> sharedKernel;
    private List<String> events;
    private List<String> applicationService;

    private boolean optionalLayers;

    //check styles
    private boolean allRingsDeepCheck;
    private List<IgnoredDependency> ignoredDependencies;
    private List<String> ignoredPackageIdentifiers;
    private List<String> adapterOutOfAdapterOutUseCaseIn;

    //clean arc pattern template
    private CleanArchitectureCheck check;

    /**
     * @deprecated Use {@link #cleanArchitecture(CleanArchitectureCheck)} instead
     */
    private CleanArchitecture(CleanArchitectureCheck check) {
        this.check = check;
        this.domainModelPackageIdentifier = DOMAIN_MODEL;
        this.domainServicePackageIdentifier = DOMAIN_SERVICE;
        this.usecaseInteractorPackageIdentifier = USECASE_INTERACTOR;
        this.adapterInPackageIdentifier = ADAPTER_IN;
        this.adapterOutPackageIdentifier = ADAPTER_OUT;
        this.useCaseInPackageIdentifier = USECASE_IN;
        this.useCaseOutPackageIdentifier = USECASE_OUT;
        this.useCasePackageIdentifier = USECASE;
        this.domainPackageIdentifier = DOMAIN;
        this.adapterPackageIdentifier = ADAPTER;
        this.adapterPackageIdentifiers = new LinkedHashMap<>();
        this.optionalLayers = true;
        this.ignoredDependencies = new ArrayList();
        this.overriddenDescription = Optional.empty();
        this.ignoredPackageIdentifiers = new ArrayList<>();
        this.sharedOutputAdapter = new ArrayList<>();
        this.supportingService = new ArrayList<>();
        this.events = new ArrayList<>();
        this.applicationService = new ArrayList<>();
        this.adapterOutOfAdapterOutUseCaseIn = new ArrayList<>();
        this.sharedKernel = new ArrayList<>();
    }

    private CleanArchitecture(CleanArchitectureCheck check,
                              Optional<String> overriddenDescription,
                              String domainModelPackageIdentifier,
                              String domainServicePackageIdentifier,
                              String usecaseInteractorPackageIdentifier,
                              String adapterInPackageIdentifier,
                              String adapterOutPackageIdentifier,
                              String useCaseInPackageIdentifier,
                              String useCaseOutPackageIdentifier,
                              String useCasePackageIdentifier,
                              String adapterPackageIdentifier,
                              String domainPackageIdentifier,
                              Map<String, String> adapterPackageIdentifiers,
                              boolean optionalLayers,
                              boolean allRingsDeepCheck,
                              List<IgnoredDependency> ignoredDependencies,
                              List<String> sharedOutputAdapter,
                              List<String> ignoredPackageIdentifiers,
                              List<String> supportingService,
                              List<String> adapterOutOfAdapterOutUseCaseIn,
                              List<String> sharedKernel) {
        this(check);
        this.overriddenDescription = overriddenDescription;
        this.domainModelPackageIdentifier = domainModelPackageIdentifier;
        this.domainServicePackageIdentifier = domainServicePackageIdentifier;
        this.usecaseInteractorPackageIdentifier = usecaseInteractorPackageIdentifier;
        this.adapterInPackageIdentifier = adapterInPackageIdentifier;
        this.adapterOutPackageIdentifier = adapterOutPackageIdentifier;
        this.useCaseInPackageIdentifier = useCaseInPackageIdentifier;
        this.useCaseOutPackageIdentifier = useCaseOutPackageIdentifier;
        this.useCasePackageIdentifier = useCasePackageIdentifier;
        this.adapterPackageIdentifier = adapterPackageIdentifier;
        this.domainPackageIdentifier = domainPackageIdentifier;
        this.adapterPackageIdentifiers = adapterPackageIdentifiers;
        this.optionalLayers = optionalLayers;
        this.allRingsDeepCheck = allRingsDeepCheck;
        this.ignoredDependencies = ignoredDependencies;
        this.sharedOutputAdapter = sharedOutputAdapter;
        this.ignoredPackageIdentifiers = ignoredPackageIdentifiers;
        this.supportingService = supportingService;
        this.adapterOutOfAdapterOutUseCaseIn = adapterOutOfAdapterOutUseCaseIn;
        this.sharedKernel = sharedKernel;
    }

    public static CleanArchitecture cleanArchitecture(CleanArchitectureCheck check) {
        return new CleanArchitecture(check);
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture domainModel(String packageIdentifier) {
        this.domainModelPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture domainService(String packageIdentifier) {
        this.domainServicePackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture usecaseInteractor(String packageIdentifier) {
        this.usecaseInteractorPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture adapterIn(String packageIdentifier) {
        this.adapterInPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture adapterOut(String packageIdentifier) {
        this.adapterOutPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture useCaseIn(String packageIdentifier) {
        this.useCaseInPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture useCaseOut(String packageIdentifier) {
        this.useCaseOutPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture useCase(String packageIdentifier) {
        this.useCasePackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture adapter(String packageIdentifier) {
        this.adapterPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture domain(String packageIdentifier) {
        this.domainPackageIdentifier = packageIdentifier;
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture adapter(String name, String packageIdentifier) {
        this.adapterPackageIdentifiers.put(name, packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture supportingService(String... packageIdentifier) {
        this.supportingService = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture sharedOutputAdapter(String... packageIdentifier) {
        this.sharedOutputAdapter = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture sharedKernel(String... packageIdentifier) {
        this.sharedKernel = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture ignore(String... packageIdentifier) {
        this.ignoredPackageIdentifiers = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture adapterOutOfAdapterOutUseCaseIn(String... packageIdentifier) {
        this.adapterOutOfAdapterOutUseCaseIn = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture applicationService(String... packageIdentifier) {
        this.applicationService = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture events(String... packageIdentifier) {
        this.events = List.of(packageIdentifier);
        return this;
    }

    @PublicAPI(usage = PublicAPI.Usage.ACCESS)
    public CleanArchitecture ignoreDependency(Class<?> origin, Class<?> target) {
        return this.ignoreDependency(JavaClass.Predicates.equivalentTo(origin), JavaClass.Predicates.equivalentTo(target));
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture ignoreDependency(String origin, String target) {
        return this.ignoreDependency(com.tngtech.archunit.core.domain.properties.HasName.Predicates.name(origin), com.tngtech.archunit.core.domain.properties.HasName.Predicates.name(target));
    }

    @PublicAPI(
            usage = PublicAPI.Usage.ACCESS
    )
    public CleanArchitecture ignoreDependency(DescribedPredicate<? super JavaClass> origin, DescribedPredicate<? super JavaClass> target) {
        this.ignoredDependencies.add(new IgnoredDependency(origin, target));
        return this;
    }

    private Architectures.LayeredArchitecture layeredArchitectureDelegate() {
        if (this.check == CleanArchitectureCheck.RINGS_AS_LAYERS) {
            return ringsAsLayers();
        } else if (this.check == CleanArchitectureCheck.DOMAIN_AND_USECASE_RING_ARCHITECTURAL_EXPRESSIVE) {
            return domainRingAndUseCaseRingArchitecturalExpressive();
        } else if (this.check == CleanArchitectureCheck.DOMAIN_RING_ARCHITECTURAL_EXPRESSIVE) {
            return domainRingArchitecturalExpressive();
        } else {
            return allRingsArchitecturalExpressive();
        }
    }

    private Architectures.LayeredArchitecture allRingsArchitecturalExpressive() {
        Architectures.LayeredArchitecture layeredArchitectureDelegate = Architectures.layeredArchitecture()
                .consideringAllDependencies()
                .layer(DOMAIN_MODEL).definedBy(this.domainModelPackageIdentifier)
                .layer(DOMAIN_SERVICE).definedBy(this.domainServicePackageIdentifier)
                .layer(USECASE_INTERACTOR).definedBy(this.usecaseInteractorPackageIdentifier)
                .layer(ADAPTER_IN).definedBy(this.adapterInPackageIdentifier)
                .layer(ADAPTER_OUT).definedBy(this.adapterOutPackageIdentifier)
                .layer(USECASE_IN).definedBy(this.useCaseInPackageIdentifier)
                .layer(USECASE_OUT).definedBy(this.useCaseOutPackageIdentifier)
                .optionalLayer(IGNORED_PACKAGES).definedBy(ignoredPackageIdentifiers.toArray(new String[0]))
                .optionalLayer(SHARED_OUTPUT_ADAPTER_PATTERN).definedBy(sharedOutputAdapter.toArray(new String[0]))
                .optionalLayer(SUPPORTING_SERVICE_PATTERN).definedBy(supportingService.toArray(new String[0]))
                .optionalLayer(SHARED_KERNEL_PATTERN).definedBy(sharedKernel.toArray(new String[0]))
                .optionalLayer(ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN).definedBy(adapterOutOfAdapterOutUseCaseIn.toArray(new String[0]))
                .optionalLayer(EVENTS_PATTERN).definedBy(events.toArray(new String[0]))
                .optionalLayer(APPLICATION_SERVICE_PATTERN).definedBy(applicationService.toArray(new String[0]))

                .whereLayer(DOMAIN_MODEL).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE_OUT,
                        USECASE_IN,
                        ADAPTER_IN,
                        ADAPTER_OUT,
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES
                )
                .whereLayer(DOMAIN_MODEL).mayNotAccessAnyLayer()
                .whereLayer(DOMAIN_SERVICE).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE_INTERACTOR).mayOnlyBeAccessedByLayers(
                        USECASE_IN,
                        USECASE_OUT,
                        ADAPTER_IN, //erlaubt auch direkte Nutzung des Interactor ohne Use Case => Full Mapping
                        ADAPTER_OUT, //erlaubt Nutzung eines Interactors, was nicht sinnvoll ist => Full Mapping
                        IGNORED_PACKAGES
                )
                .whereLayer(ADAPTER_IN).mayOnlyBeAccessedByLayers(
                        IGNORED_PACKAGES
                )
                .whereLayer(ADAPTER_OUT).mayOnlyBeAccessedByLayers(
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE_IN).mayOnlyBeAccessedByLayers(
                        ADAPTER_IN,
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES,
                        ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN,
                        EVENTS_PATTERN,
                        APPLICATION_SERVICE_PATTERN
                )
                .whereLayer(USECASE_OUT).mayOnlyBeAccessedByLayers(
                        ADAPTER_OUT,
                        USECASE_INTERACTOR,
                        SHARED_OUTPUT_ADAPTER_PATTERN,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_OUTPUT_ADAPTER_PATTERN).mayOnlyBeAccessedByLayers(
                        IGNORED_PACKAGES
                )
                .whereLayer(SUPPORTING_SERVICE_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        DOMAIN_SERVICE,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_KERNEL_PATTERN).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE_OUT,
                        USECASE_IN,
                        ADAPTER_IN,
                        ADAPTER_OUT,
                        USECASE_INTERACTOR,
                        DOMAIN_MODEL
                )
                .withOptionalLayers(true);

        enrichWithIgnoreDependencies(layeredArchitectureDelegate);

        return layeredArchitectureDelegate.as(this.getDescription());
    }

    private Architectures.LayeredArchitecture domainRingAndUseCaseRingArchitecturalExpressive() {
        Architectures.LayeredArchitecture layeredArchitectureDelegate = Architectures.layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer(DOMAIN_MODEL).definedBy(this.domainModelPackageIdentifier)
                .layer(DOMAIN_SERVICE).definedBy(this.domainServicePackageIdentifier)
                .optionalLayer(USECASE_INTERACTOR).definedBy(this.usecaseInteractorPackageIdentifier)
                .layer(USECASE_IN).definedBy(this.useCaseInPackageIdentifier)
                .layer(USECASE_OUT).definedBy(this.useCaseOutPackageIdentifier)
                .layer(ADAPTER).definedBy(this.adapterPackageIdentifier)
                .optionalLayer(IGNORED_PACKAGES).definedBy(ignoredPackageIdentifiers.toArray(new String[0]))
                .optionalLayer(SHARED_KERNEL_PATTERN).definedBy(sharedKernel.toArray(new String[0]))
                .optionalLayer(SHARED_OUTPUT_ADAPTER_PATTERN).definedBy(sharedOutputAdapter.toArray(new String[0]))
                .optionalLayer(ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN).definedBy(adapterOutOfAdapterOutUseCaseIn.toArray(new String[0]))
                .optionalLayer(EVENTS_PATTERN).definedBy(events.toArray(new String[0]))
                .optionalLayer(SUPPORTING_SERVICE_PATTERN).definedBy(supportingService.toArray(new String[0]))
                .optionalLayer(ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN).definedBy(adapterOutOfAdapterOutUseCaseIn.toArray(new String[0]))
                .whereLayer(DOMAIN_MODEL).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE_OUT,
                        USECASE_IN,
                        ADAPTER,
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES,
                        SHARED_OUTPUT_ADAPTER_PATTERN
                )
                .whereLayer(DOMAIN_SERVICE).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE_INTERACTOR).mayOnlyBeAccessedByLayers(
                        USECASE_IN,
                        USECASE_OUT,
                        ADAPTER_IN,
                        ADAPTER_OUT,
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE_IN).mayOnlyBeAccessedByLayers(
                        ADAPTER,
                        USECASE_INTERACTOR,
                        DOMAIN_SERVICE,
                        IGNORED_PACKAGES,
                        ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN,
                        EVENTS_PATTERN,
                        APPLICATION_SERVICE_PATTERN
                )
                .whereLayer(USECASE_OUT).mayOnlyBeAccessedByLayers(
                        ADAPTER,
                        DOMAIN_SERVICE,
                        USECASE_INTERACTOR,
                        SHARED_OUTPUT_ADAPTER_PATTERN,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_OUTPUT_ADAPTER_PATTERN).mayOnlyBeAccessedByLayers(
                        IGNORED_PACKAGES
                )
                .whereLayer(SUPPORTING_SERVICE_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        DOMAIN_SERVICE,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_KERNEL_PATTERN).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE_OUT,
                        USECASE_IN,
                        ADAPTER,
                        USECASE_INTERACTOR,
                        DOMAIN_MODEL,
                        IGNORED_PACKAGES
                )
                .withOptionalLayers(true);

        enrichWithIgnoreDependencies(layeredArchitectureDelegate);
        //enrichWithAdapters(layeredArchitectureDelegate, this.adapterPackageIdentifiers);
        return layeredArchitectureDelegate.as(this.getDescription());
    }

    private Architectures.LayeredArchitecture domainRingArchitecturalExpressive() {
        Architectures.LayeredArchitecture layeredArchitectureDelegate = Architectures.layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer(DOMAIN_MODEL).definedBy(this.domainModelPackageIdentifier)
                .layer(DOMAIN_SERVICE).definedBy(this.domainServicePackageIdentifier)
                .layer(ADAPTER).definedBy(this.adapterPackageIdentifier)
                .optionalLayer(USECASE_INTERACTOR).definedBy(this.usecaseInteractorPackageIdentifier)
                .layer(USECASE).definedBy(this.useCasePackageIdentifier)
                .optionalLayer(IGNORED_PACKAGES).definedBy(ignoredPackageIdentifiers.toArray(new String[0]))
                .optionalLayer(SHARED_KERNEL_PATTERN).definedBy(sharedKernel.toArray(new String[0]))
                .optionalLayer(SHARED_OUTPUT_ADAPTER_PATTERN).definedBy(sharedOutputAdapter.toArray(new String[0]))
                .optionalLayer(ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN).definedBy(adapterOutOfAdapterOutUseCaseIn.toArray(new String[0]))
                .optionalLayer(EVENTS_PATTERN).definedBy(events.toArray(new String[0]))
                .optionalLayer(SUPPORTING_SERVICE_PATTERN).definedBy(supportingService.toArray(new String[0]))
                .optionalLayer(ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN).definedBy(adapterOutOfAdapterOutUseCaseIn.toArray(new String[0]))
                .whereLayer(DOMAIN_MODEL).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE,
                        ADAPTER,
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES,
                        SHARED_OUTPUT_ADAPTER_PATTERN
                )
                .whereLayer(DOMAIN_SERVICE).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_OUTPUT_ADAPTER_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE,
                        DOMAIN_MODEL,
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE_INTERACTOR).mayOnlyBeAccessedByLayers(
                        USECASE,
                        ADAPTER,
                        IGNORED_PACKAGES
                )
                .whereLayer(USECASE).mayOnlyBeAccessedByLayers(
                        ADAPTER,
                        USECASE_INTERACTOR,
                        DOMAIN_SERVICE,
                        IGNORED_PACKAGES,
                        ADAPTER_OUT_OF_ADAPTER_OUT_USE_CASE_IN_PATTERN,
                        SHARED_OUTPUT_ADAPTER_PATTERN,
                        EVENTS_PATTERN,
                        APPLICATION_SERVICE_PATTERN
                )
                .whereLayer(SHARED_OUTPUT_ADAPTER_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE,
                        DOMAIN_MODEL,
                        IGNORED_PACKAGES
                )
                .whereLayer(SUPPORTING_SERVICE_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE_INTERACTOR,
                        DOMAIN_SERVICE,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_KERNEL_PATTERN).mayOnlyBeAccessedByLayers(
                        DOMAIN_SERVICE,
                        USECASE,
                        ADAPTER,
                        USECASE_INTERACTOR,
                        DOMAIN_MODEL,
                        IGNORED_PACKAGES
                )
                .withOptionalLayers(true);

        enrichWithIgnoreDependencies(layeredArchitectureDelegate);
        //enrichWithAdapters(layeredArchitectureDelegate, this.adapterPackageIdentifiers);
        return layeredArchitectureDelegate.as(this.getDescription());
    }

    private Architectures.LayeredArchitecture ringsAsLayers() {
        Architectures.LayeredArchitecture layeredArchitectureDelegate = Architectures.layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer(DOMAIN).definedBy(this.domainPackageIdentifier)
                .layer(USECASE).definedBy(this.useCasePackageIdentifier)
                .layer(ADAPTER).definedBy(this.adapterPackageIdentifier)
                .optionalLayer(IGNORED_PACKAGES).definedBy(ignoredPackageIdentifiers.toArray(new String[0]))
                .optionalLayer(SHARED_OUTPUT_ADAPTER_PATTERN).definedBy(sharedOutputAdapter.toArray(new String[0]))
                .optionalLayer(SHARED_KERNEL_PATTERN).definedBy(sharedKernel.toArray(new String[0]))
                .optionalLayer(SUPPORTING_SERVICE_PATTERN).definedBy(supportingService.toArray(new String[0]))
                .whereLayer(DOMAIN).mayOnlyBeAccessedByLayers(
                        USECASE,
                        ADAPTER,
                        IGNORED_PACKAGES,
                        SHARED_OUTPUT_ADAPTER_PATTERN
                )
                .whereLayer(USECASE).mayOnlyBeAccessedByLayers(
                        ADAPTER,
                        DOMAIN,
                        IGNORED_PACKAGES,
                        SHARED_OUTPUT_ADAPTER_PATTERN
                )
                .whereLayer(ADAPTER).mayNotBeAccessedByAnyLayer()
                .whereLayer(SHARED_OUTPUT_ADAPTER_PATTERN).mayOnlyBeAccessedByLayers(
                        USECASE,
                        DOMAIN,
                        IGNORED_PACKAGES
                )
                .whereLayer(SUPPORTING_SERVICE_PATTERN).mayOnlyBeAccessedByLayers(
                        DOMAIN,
                        IGNORED_PACKAGES
                )
                .whereLayer(SHARED_KERNEL_PATTERN).mayOnlyBeAccessedByLayers(
                        DOMAIN,
                        USECASE,
                        ADAPTER,
                        IGNORED_PACKAGES
                )
                .withOptionalLayers(true);

        enrichWithIgnoreDependencies(layeredArchitectureDelegate);
        return layeredArchitectureDelegate.as(this.getDescription());
    }

    private void enrichWithIgnoreDependencies(Architectures.LayeredArchitecture layeredArchitectureDelegate) {
        Iterator var2;
        IgnoredDependency ignoredDependency;
        for (var2 = this.ignoredDependencies.iterator(); var2.hasNext(); layeredArchitectureDelegate = ignoredDependency.ignoreFor(layeredArchitectureDelegate)) {
            ignoredDependency = (IgnoredDependency) var2.next();
        }
    }

    private void enrichWithAdapters(Architectures.LayeredArchitecture layeredArchitectureDelegate, Map<String, String> packageIdentifiers) {
        Iterator var2;
        Map.Entry adapter;
        String adapterLayer;
        for (var2 = packageIdentifiers.entrySet().iterator(); var2.hasNext(); layeredArchitectureDelegate = layeredArchitectureDelegate.layer(adapterLayer).definedBy((String[]) adapter.getValue()).whereLayer(adapterLayer).mayNotBeAccessedByAnyLayer()) {
            adapter = (Map.Entry) var2.next();
            adapterLayer = this.getAdapterLayer((String) adapter.getKey());
        }
    }

    private String[] concatenateAll(Collection<String[]> arrays) {
        List<String> resultList = new ArrayList();
        Iterator var3 = arrays.iterator();

        while (var3.hasNext()) {
            String[] array = (String[]) var3.next();
            resultList.addAll(Arrays.asList(array));
        }

        return (String[]) resultList.toArray(new String[0]);
    }

    private String getAdapterLayer(String name) {
        return String.format("%s %s", name, "adapter");
    }

    public void check(JavaClasses classes) {
        this.layeredArchitectureDelegate().check(classes);
    }

    public ArchRule because(String reason) {
        return Factory.withBecause(this, reason);
    }

    @Override
    public ArchRule allowEmptyShould(boolean allowEmptyShould) {
        this.optionalLayers = allowEmptyShould;
        return this;
    }

    public CleanArchitecture as(String newDescription) {
        return new CleanArchitecture(this.check,
                Optional.of(newDescription),
                domainModelPackageIdentifier,
                domainServicePackageIdentifier,
                usecaseInteractorPackageIdentifier,
                adapterInPackageIdentifier,
                adapterOutPackageIdentifier,
                useCaseInPackageIdentifier,
                useCaseOutPackageIdentifier,
                useCasePackageIdentifier,
                adapterPackageIdentifier,
                domainPackageIdentifier,
                adapterPackageIdentifiers,
                optionalLayers,
                allRingsDeepCheck,
                ignoredDependencies,
                sharedOutputAdapter,
                ignoredPackageIdentifiers,
                supportingService,
                adapterOutOfAdapterOutUseCaseIn,
                sharedKernel);
    }

    public EvaluationResult evaluate(JavaClasses classes) {
        return this.layeredArchitectureDelegate().evaluate(classes);
    }

    public String getDescription() {
        if (this.overriddenDescription.isPresent()) {
            return (String) this.overriddenDescription.get();
        } else {
            return "Clean architecture fitness function in mode " + check.toString();
        }
    }

    private static class IgnoredDependency {
        private final DescribedPredicate<? super JavaClass> origin;
        private final DescribedPredicate<? super JavaClass> target;

        IgnoredDependency(DescribedPredicate<? super JavaClass> origin, DescribedPredicate<? super JavaClass> target) {
            this.origin = origin;
            this.target = target;
        }

        Architectures.LayeredArchitecture ignoreFor(Architectures.LayeredArchitecture layeredArchitecture) {
            return layeredArchitecture.ignoreDependency(this.origin, this.target);
        }
    }

}
