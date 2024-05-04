package org.bobpark.core.configure.jpa;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.bobpark.core.configure.jpa.properties.JpaProperties;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(JpaProperties.class)
public class JpaAutoConfiguration {

    @PostConstruct
    public void init() {
        log.debug("Initialized jpa auto configuration...");
    }

    @ConditionalOnMissingBean
    @Bean
    public JPAQueryFactory defaultJpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }
}
