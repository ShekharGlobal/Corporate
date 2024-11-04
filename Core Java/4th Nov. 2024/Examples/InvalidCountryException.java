package com.coforge.exceptions;
public class InvalidCountryException extends Exception {
    
    // Constructor that accepts a message
    public InvalidCountryException(final String message) {
        super(message);
    }

    // Constructor that accepts a Throwable
    public InvalidCountryException(final Throwable exception) {
        super(exception);
    }

    // Constructor that accepts both a message and a Throwable
    public InvalidCountryException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
