package com.sdiaz.moneta.customer_service.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data,
        LocalDateTime timestamp,
        int status,
        List<String> errors
) {
    public static <T> ApiResponse<T> success(
            T data,
            String message,
            int status
    ) {
        return new ApiResponse<>(
                true,
                message,
                data,
                LocalDateTime.now(),
                status,
                null
        );
    }

    public static <T> ApiResponse<T> error(
            List<String> errors,
            String message,
            int status
    ) {
        return new ApiResponse<>(
                false,
                message,
                null,
                LocalDateTime.now(),
                status,
                errors
        );
    }
}
