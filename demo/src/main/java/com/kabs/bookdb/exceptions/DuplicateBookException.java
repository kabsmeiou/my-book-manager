package com.kabs.bookdb.exceptions;

public class DuplicateBookException extends RuntimeException{
    public DuplicateBookException(String message) {
        super(message);
    }
}
