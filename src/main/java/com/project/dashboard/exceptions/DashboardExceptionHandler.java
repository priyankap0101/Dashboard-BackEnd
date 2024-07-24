package com.project.dashboard.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.dashboard.util.responseStructure;

@RestControllerAdvice
public class DashboardExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<responseStructure<Map<String, String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ObjectError> list = ex.getAllErrors();
        Map<String, String> errors = new HashMap<>();

        for (ObjectError error : list) {
            String message = error.getDefaultMessage();
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName, message);
        }

        responseStructure<Map<String, String>> response = new responseStructure<>();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Validation failed");
        response.setData(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<responseStructure<String>> handleGeneralException(Exception ex) {
        responseStructure<String> response = new responseStructure<>();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("An unexpected error occurred");
        response.setData(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
