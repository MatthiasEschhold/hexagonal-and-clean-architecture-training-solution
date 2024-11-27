package de.arkem.shared.domain.model.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppModule {
    String name();
    String[] allowedDependencies() default {};
    String[] exposedPackages() default {};
}
