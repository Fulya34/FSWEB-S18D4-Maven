package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException ex) {
        return new ResponseEntity<>(
                new BurgerErrorResponse(ex.getMessage()),
                ex.getHttpStatus()
        );
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(
                new BurgerErrorResponse(ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
