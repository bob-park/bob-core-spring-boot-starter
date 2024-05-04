package org.bobpark.core.configure.jpa.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JpaCondition implements Condition {

    private static final String PROPERTY_ENABLE_KEY = "bob-core.jpa.enabled";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty(PROPERTY_ENABLE_KEY, Boolean.class, true);
    }
}
