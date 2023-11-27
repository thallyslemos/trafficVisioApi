package com.thallys.trafficvision.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionSchema> methodArgumentNotValidException(HttpServletRequest request,
            HttpServletResponse response, MethodArgumentNotValidException exception) {
        ExceptionSchema exceptionSchema = new ExceptionSchema();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        exceptionSchema.setMessage(exception.getFieldError().getDefaultMessage());
        exceptionSchema.setStatus(status.value());
        exceptionSchema.setTime(Instant.now());
        exceptionSchema.setPath(request.getRequestURI());
        return new ResponseEntity<>(exceptionSchema, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionSchema> runtimeException(HttpServletRequest request, HttpServletResponse response,
            RuntimeException exception) {
        ExceptionSchema exceptionSchema = new ExceptionSchema();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        exceptionSchema.setMessage(exception.getMessage());
        exceptionSchema.setStatus(status.value());
        exceptionSchema.setTime(Instant.now());
        exceptionSchema.setPath(request.getRequestURI());
        return new ResponseEntity<>(exceptionSchema, status);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<ExceptionSchema> internalAuthenticationServiceException(HttpServletRequest request,
            HttpServletResponse response, InternalAuthenticationServiceException exception) {
        ExceptionSchema exceptionSchema = new ExceptionSchema();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        exceptionSchema.setMessage(exception.getMessage());
        exceptionSchema.setStatus(status.value());
        exceptionSchema.setTime(Instant.now());
        exceptionSchema.setPath(request.getRequestURI());
        return new ResponseEntity<>(exceptionSchema, status);
    }
}
