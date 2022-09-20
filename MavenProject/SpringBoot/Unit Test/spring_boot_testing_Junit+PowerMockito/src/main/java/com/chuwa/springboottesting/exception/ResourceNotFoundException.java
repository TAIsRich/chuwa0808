package com.chuwa.springboottesting.exception;

/**
 * @author b1go
 * @date 7/10/22 6:47 PM
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
