package com.chuwa.redbook2.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */

    public BlogAPIException(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;

    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */

    public BlogAPIException(HttpStatus httpStatus, String message, String message1){
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;

    }

    public HttpStatus getHttpStatus(){return httpStatus;}

    public void setHttpStatus(HttpStatus httpStatus){this.httpStatus = httpStatus;}

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
