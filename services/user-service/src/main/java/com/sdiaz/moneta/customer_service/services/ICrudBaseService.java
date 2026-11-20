package com.sdiaz.moneta.customer_service.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICrudBaseService<T, ID> {
    Flux<T> findAll();
    Mono<T> findById(ID id);
    Mono<T> create(T object);
    Mono<T> update(ID id, T object);
    Mono<T> deleteById(ID id);
}
