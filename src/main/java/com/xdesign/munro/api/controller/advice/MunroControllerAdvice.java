package com.xdesign.munro.api.controller.advice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class MunroControllerAdvice {

    @ExceptionHandler( ValidationException.class )
    public ResponseEntity<Map<String, String>> handleValidationException( ValidationException exception ) {
        String message = StringUtils.isNotBlank( exception.getMessage() ) ? exception.getMessage() : "An error occurred";

        return ResponseEntity.badRequest().body( Collections.singletonMap( "error", message ) );
    }
}