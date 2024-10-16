package com.eldar.challenge_java.config;

import com.eldar.challenge_java.dto.ErrorDto;
import com.eldar.challenge_java.exception.UnsupportedBrandException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedBrandException.class)
    public ResponseEntity<ErrorDto> handleUnsupportedBrandException(UnsupportedBrandException ex) {
        ErrorDto error = new ErrorDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorDto error = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> new ErrorDto(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        fieldError.getDefaultMessage()
                        ))
                .orElse(new ErrorDto(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Unknown validation error"));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

