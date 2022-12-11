package com.prodius.exeption;

public class UserInputException extends RuntimeException{
    public UserInputException(final String message) {
        super(message);
    }
}
