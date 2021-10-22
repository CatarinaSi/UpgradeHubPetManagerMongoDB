package com.pet.manager.exception;

public class DuplicatePetException extends RuntimeException {
    public DuplicatePetException() {
        super("Pet with that name already exists.");
    }
    public DuplicatePetException(String message) {
        super(message);
    }
}
