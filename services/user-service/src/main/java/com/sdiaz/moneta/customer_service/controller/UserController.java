package com.sdiaz.moneta.customer_service.controller;

import com.sdiaz.moneta.customer_service.dto.request.UserRequest;
import com.sdiaz.moneta.customer_service.dto.response.ApiResponse;
import com.sdiaz.moneta.customer_service.dto.response.UserResponse;
import com.sdiaz.moneta.customer_service.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/all", "", "/list"})
    public Mono<ApiResponse<List<UserResponse>>> findAll() {
        return userService.findAllActive()
                .map(UserResponse::toDto)
                .collectList()
                .map(users -> ApiResponse.success(
                        users,
                        "List of users!",
                        HttpStatus.OK.value()
                ));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<ApiResponse<UserResponse>> findById(@PathVariable UUID id) {
        return userService.findActiveById(id)
                .map(UserResponse::toDto)
                .map(dto -> ApiResponse.success(
                        dto,
                        "User found successfully!",
                        HttpStatus.OK.value()
                ));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Mono<ApiResponse<UserResponse>> create(@Valid @RequestBody UserRequest user) {
        var userEntity = UserRequest.toEntity(user);
        return userService.create(userEntity)
                .map(UserResponse::toDto)
                .map(dto -> ApiResponse.success(
                        dto,
                        "User created successfully!",
                        HttpStatus.CREATED.value()
                ));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/update")
    public Mono<ApiResponse<UserResponse>> update(
            @PathVariable UUID id,
            @Valid @RequestBody UserRequest user
    ) {
        var userEntity = UserRequest.toEntity(user);
        return userService.update(
                        id,
                        userEntity
                )
                .map(UserResponse::toDto)
                .map(dto -> ApiResponse.success(
                        dto,
                        "User updated successfully!",
                        HttpStatus.OK.value()
                ));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/delete")
    public Mono<ApiResponse<UserResponse>> delete(@PathVariable UUID id) {
        return userService.deleteById(id)
                .map(UserResponse::toDto)
                .map(dto -> ApiResponse.success(
                        dto,
                        "User deleted successfully!",
                        HttpStatus.NO_CONTENT.value()
                ));
    }
}
