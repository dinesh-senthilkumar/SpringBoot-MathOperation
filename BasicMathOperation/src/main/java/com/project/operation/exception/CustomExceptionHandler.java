package com.project.operation.exception;

import com.project.operation.model.CustomErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler{
    private static final Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class);
    CustomErrorResponse errors = new CustomErrorResponse();

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<CustomErrorResponse> userManagementInterfaceError(Exception exception) {
        LOGGER.error(exception.getMessage());
        errors.setCode(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }





}