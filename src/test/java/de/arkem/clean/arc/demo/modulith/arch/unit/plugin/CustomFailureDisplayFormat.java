package de.arkem.clean.arc.demo.modulith.arch.unit.plugin;

import com.tngtech.archunit.base.HasDescription;
import com.tngtech.archunit.lang.FailureDisplayFormat;
import com.tngtech.archunit.lang.FailureMessages;
import com.tngtech.archunit.lang.Priority;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class CustomFailureDisplayFormat implements FailureDisplayFormat {
    @Override
    public String formatFailure(HasDescription rule, FailureMessages failureMessages, Priority priority) {
        String failureDetails = failureMessages.stream()
                .map(message -> message.replaceAll("<(?:\\w+\\.)+([A-Z][^>]*)>", "<$1>"))
                .collect(joining(lineSeparator()));

        return String.format("Architecture Violation [Priority: %s] - Rule '%s' was violated (%s):%n%s",
                priority.asString(), rule.getDescription(), failureMessages.getInformationAboutNumberOfViolations(), failureDetails);
    }
}