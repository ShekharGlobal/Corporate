package com.coforge.exceptions;
public class InvalidAgeException extends Exception {

    // Constructor that accepts a message
    public InvalidAgeException(final String message) {
        super(message);
    }

    // Constructor that accepts a Throwable
    public InvalidAgeException(final Throwable exception) {
        super(exception);
    }

    // Constructor that accepts both a message and a Throwable
    public InvalidAgeException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
