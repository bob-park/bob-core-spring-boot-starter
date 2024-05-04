package org.bobpark.core.configure.jpa.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("bob-core.jpa")
public record JpaProperties(@DefaultValue("true") boolean enabled) {
}
