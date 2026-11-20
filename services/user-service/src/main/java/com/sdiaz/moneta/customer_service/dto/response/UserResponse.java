package com.sdiaz.moneta.customer_service.dto.response;

import com.sdiaz.moneta.customer_service.entities.UserEntity;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String displayName,
        Boolean active
) {
    public static UserResponse toDto(UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getEmail(),
                entity.getDisplayName(),
                entity.getActive()
        );
    }
}
