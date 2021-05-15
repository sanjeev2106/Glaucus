package com.example.number.exception;

import org.springframework.http.HttpStatus;

/**
 * This class is a custom Exception class to handle the base exception messages
 *
 * @author Sanjeev
 */
public class GenericException extends Exception {

    /**
     * This is the public constructor for Exception
     *
     * @param excMessage
     * @param errorCode
     */
    public GenericException(String excMessage, HttpStatus errorCode) {

        super(excMessage);
        setStatus(errorCode);
        setErrorMessage(excMessage);
    }

    private String errorMessage = null;
    private HttpStatus status;

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
