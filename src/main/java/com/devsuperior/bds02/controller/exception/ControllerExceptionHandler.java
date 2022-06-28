package com.devsuperior.bds02.controller.exception;

import com.devsuperior.bds02.services.exception.DatabaseException;
import com.devsuperior.bds02.services.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFound() {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<?> dataBaseException() {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
