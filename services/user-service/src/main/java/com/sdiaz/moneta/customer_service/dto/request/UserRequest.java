package com.sdiaz.moneta.customer_service.dto.request;

import com.sdiaz.moneta.customer_service.entities.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 5, max = 255)
        String password,
        @NotBlank
        @Size(min = 2, max = 255)
        String displayName
) {

    public static UserEntity toEntity(UserRequest request) {
        return UserEntity.builder()
                .email(request.email)
                .passwordHash(request.password)
                .displayName(request.displayName)
                .build();
    }
}
