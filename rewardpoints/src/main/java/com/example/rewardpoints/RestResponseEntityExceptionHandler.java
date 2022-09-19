package com.example.rewardpoints;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        String msg = "Getting an error when running the service";
        return handleExceptionInternal(ex, msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
