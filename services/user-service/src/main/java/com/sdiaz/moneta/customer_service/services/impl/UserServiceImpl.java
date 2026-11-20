package com.sdiaz.moneta.customer_service.services.impl;

import com.sdiaz.moneta.customer_service.entities.UserEntity;
import com.sdiaz.moneta.customer_service.exception.DuplicateEmailException;
import com.sdiaz.moneta.customer_service.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl extends CrudBaseServiceImpl<UserEntity, UUID> {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder
    ) {
        super(
                userRepository,
                "User"
        );
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<UserEntity> findActiveById(UUID uuid) {
        return userRepository.findActiveById(uuid);
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<UserEntity> findAllActive() {
        return userRepository.findAllActive();
    }

    @Transactional
    @Override
    public Mono<UserEntity> create(UserEntity object) {
        var email = object.getEmail();
        return userRepository.existsByEmail(email)
                .flatMap(exists -> {
                    if (exists)
                        Mono.error(new DuplicateEmailException(email));
                    var passwordHash = passwordEncoder.encode(
                            object.getPasswordHash()
                    );
                    object.setPasswordHash(passwordHash);
                    object.setCreatedAt(LocalDateTime.now());
                    return userRepository.save(object);
                });
    }

    @Override
    UserEntity updateAndGetUpdatedValues(
            UserEntity object,
            UserEntity bd
    ) {
        Optional.ofNullable(object.getEmail()).ifPresent(bd::setEmail);
        Optional.ofNullable(object.getDisplayName()).ifPresent(bd::setDisplayName);
        Optional.ofNullable(object.getPasswordHash()).ifPresent(bd::setPasswordHash);
        bd.setUpdatedAt(LocalDateTime.now());
        return bd;
    }

    @Override
    UserEntity disable(UserEntity bd) {
        bd.setActive(false);
        return bd;
    }
}
