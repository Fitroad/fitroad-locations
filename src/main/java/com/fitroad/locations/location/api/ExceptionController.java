package com.fitroad.locations.location.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fitroad.locations.exception.NotFoundException;
import com.fitroad.locations.location.BaseLocationResponse;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleRuntimeException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        return ResponseEntity.internalServerError().body(new BaseLocationResponse(message));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException) {
        String message = notFoundException.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseLocationResponse(message));
    }
}
