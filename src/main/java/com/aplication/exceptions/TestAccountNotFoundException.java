package com.aplication.exceptions;

public class TestAccountNotFoundException extends RuntimeException{
    public TestAccountNotFoundException(String message) {
        super(message);
    }
}
