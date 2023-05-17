package com.aplication.exceptions;

public class RepairNotFoundException extends RuntimeException{
    public RepairNotFoundException(String message) {
        super(message);
    }
}
