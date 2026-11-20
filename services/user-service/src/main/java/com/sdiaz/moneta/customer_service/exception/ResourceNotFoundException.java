package com.sdiaz.moneta.customer_service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(
            Object id,
            String message
    ) {
        super("%s with id: %s not found".formatted(
                message,
                id
        ));
    }
}
