package com.sdiaz.moneta.customer_service.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("Email already exists: %s".formatted(email));
    }
}
