package org.bobpark.core.controller;

import static org.bobpark.core.model.api.ApiResult.*;

import jakarta.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.bobpark.core.exception.NotFoundException;
import org.bobpark.core.model.api.ApiResult;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @PostConstruct
    public void init() {
        log.info("bob-core enabled GlobalControllerAdvice.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class})
    public <T> ApiResult<T> badRequest(Exception e) {
        return error("Bad request", e);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public <T> ApiResult<T> accessDenied(AccessDeniedException e) {
        return error("Forbidden", e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public <T> ApiResult<T> notFound(Exception e) {

        if (log.isWarnEnabled()) {
            log.warn("Not Found - {}", e.getMessage());
        }

        return error(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public <T> ApiResult<T> internalServerError(Exception e) {

        log.error("Service Error - {}", e.getMessage(), e);

        return error(e);
    }

}
