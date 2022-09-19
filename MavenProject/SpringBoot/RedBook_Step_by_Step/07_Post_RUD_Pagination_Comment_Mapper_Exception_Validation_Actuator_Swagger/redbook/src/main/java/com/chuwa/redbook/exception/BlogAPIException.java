package com.chuwa.redbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlogAPIException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    /**
     * Construct a new runtime exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}.
     */
    public BlogAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Construct a new runtime exception with the specified detail message: super(message).
     * The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause}
     *
     * @param message: the super's (runtime exception's) detail message.
     *                 the detail message is saved for later retrieval by the {@link #getMessage()} method
     */
     public BlogAPIException(String message, HttpStatus httpStatus, String message1) {
         super(message); // super's message
         this.httpStatus = httpStatus;
         this.message = message1; // sub's message
     }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
