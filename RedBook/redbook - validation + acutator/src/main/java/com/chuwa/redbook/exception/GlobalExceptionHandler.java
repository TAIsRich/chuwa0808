package com.chuwa.redbook.exception;

import com.chuwa.redbook.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetials = new ErrorDetails(new Date(), exception.getMessage(),
                 webRequest.getDescription(false));

         return new ResponseEntity<>(errorDetials, HttpStatus.NOT_FOUND);
     }

     @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleBlogAPIException(BlogAPIException exception,
                                                               WebRequest webRequest) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                 webRequest.getDescription(false));

         return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
     }

     @ExceptionHandler
     public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                               WebRequest webRequest) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                 webRequest.getDescription(false));

         return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
     }
}
