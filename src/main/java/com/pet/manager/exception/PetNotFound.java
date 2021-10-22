package com.pet.manager.exception;

public class PetNotFound extends RuntimeException {
    public PetNotFound() {
        super("Pet not found.");
    }
    public PetNotFound(String message) {
        super(message);
    }
}