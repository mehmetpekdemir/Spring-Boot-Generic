package com.mehmetpekdemir.generic.controller;

import com.mehmetpekdemir.generic.dto.request.UserCreateRequest;
import com.mehmetpekdemir.generic.dto.request.UserUpdateRequest;
import com.mehmetpekdemir.generic.dto.response.UserResponse;
import com.mehmetpekdemir.generic.common.generic.GenericController;
import com.mehmetpekdemir.generic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController implements GenericController<UserResponse, UserCreateRequest, UserUpdateRequest> {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> findById(Long id) {
        final var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAll() {
        final var users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<List<UserResponse>> findPaginated(Pageable pageable) {
        final var users = userService.findPaginated(pageable);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserResponse> create(@Valid UserCreateRequest userCreateRequest) {
        final var user = userService.create(userCreateRequest);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserResponse> update(@Valid UserUpdateRequest userUpdateRequest) {
        final var user = userService.update(userUpdateRequest);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
