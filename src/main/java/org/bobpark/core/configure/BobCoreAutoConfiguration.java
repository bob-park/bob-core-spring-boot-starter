package org.bobpark.core.configure;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import org.bobpark.core.configure.condition.BobCoreCondition;
import org.bobpark.core.configure.properties.BobCoreProperties;
import org.bobpark.core.controller.GlobalControllerAdvice;

@AutoConfiguration
@EnableConfigurationProperties(BobCoreProperties.class)
@Conditional(BobCoreCondition.class)
public class BobCoreAutoConfiguration {

    @Bean
    public GlobalControllerAdvice globalControllerAdvice() {
        return new GlobalControllerAdvice();
    }
}
