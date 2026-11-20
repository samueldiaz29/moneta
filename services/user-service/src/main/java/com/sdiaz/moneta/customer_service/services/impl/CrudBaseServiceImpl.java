package com.sdiaz.moneta.customer_service.services.impl;

import com.sdiaz.moneta.customer_service.exception.ResourceNotFoundException;
import com.sdiaz.moneta.customer_service.services.ICrudBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public abstract class CrudBaseServiceImpl<T, ID> implements ICrudBaseService<T, ID> {
    private final ReactiveCrudRepository<T, ID> repository;
    private final String resourceName;

    @Transactional(readOnly = true)
    @Override
    public Flux<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<T> findById(ID id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(
                        id,
                        resourceName
                )));
    }

    @Transactional
    @Override
    public Mono<T> create(T object) {
        return repository.save(object);
    }

    @Transactional
    @Override
    public Mono<T> update(
            ID id,
            T object
    ) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(id, resourceName)))
                .map(bd -> updateAndGetUpdatedValues(object, bd))
                .flatMap(repository::save);
    }

    @Transactional
    @Override
    public Mono<T> deleteById(ID id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(id, resourceName)))
                .map(this::disable)
                .flatMap(repository::save);
    }

    abstract Mono<T> findActiveById(ID id);
    abstract Flux<T> findAllActive();
    abstract T updateAndGetUpdatedValues(T object, T bd);
    abstract T disable(T bd);
}
