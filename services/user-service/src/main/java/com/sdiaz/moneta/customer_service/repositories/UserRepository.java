package com.sdiaz.moneta.customer_service.repositories;

import com.sdiaz.moneta.customer_service.entities.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, UUID> {
    @Query("""
            SELECT * FROM users
            WHERE active = TRUE AND id = :id
            """)
    Mono<UserEntity> findActiveById(UUID id);

    @Query("""
            SELECT * FROM users
            WHERE active = TRUE
            """)
    Flux<UserEntity> findAllActive();

    @Query("""
            SELECT * FROM users
            WHERE email = :email
            """)
    Mono<Boolean> existsByEmail(String email);
}
