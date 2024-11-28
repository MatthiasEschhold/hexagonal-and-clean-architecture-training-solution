package de.arkem.clean.arc.demo.modular.monolith.fitness.function.template.based;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "de.arkem.clean.arc.demo",
        importOptions = {ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class})
public class ArchitecturePatternWithOnionTemplateTest {

    @ArchTest
    void test(JavaClasses classes) {
        Architectures.OnionArchitecture rule = onionArchitecture()
            .domainModels("..domain.model..")
            .domainServices("..domain.service..")
            .applicationServices("..usecase.interactor..")
            .adapter("adapter.out", "..adapter.out..")
            .adapter("adapter.in", "..adapter.in..");
        rule.check(classes);
    }
}
