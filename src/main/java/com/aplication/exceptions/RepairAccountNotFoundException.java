package com.aplication.exceptions;

public class RepairAccountNotFoundException extends RuntimeException{
    public RepairAccountNotFoundException(String message) {
        super(message);
    }
}
