package com.educandoweb.course.resources.exceptions;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// @ para interceptar as exceções
@ControllerAdvice
public class ResourceExceptionHandler {

    // Estamos interceptando a exceção ResourceNotFoundException e vai tratar com o que tiver dentro da função
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest request) {
        String errorS = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), errorS, error.getMessage(), request.getRequestURI());

        // Retorna então o status, passando no body o objeto err que recebe tudo
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException error, HttpServletRequest request) {
        String errorS = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), errorS, error.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
