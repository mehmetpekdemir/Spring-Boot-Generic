package com.mehmetpekdemir.generic.service;

import com.mehmetpekdemir.generic.dto.request.UserCreateRequest;
import com.mehmetpekdemir.generic.dto.request.UserUpdateRequest;
import com.mehmetpekdemir.generic.dto.response.UserResponse;

import com.mehmetpekdemir.generic.entity.UserEntity;
import com.mehmetpekdemir.generic.exception.UserNotFoundException;
import com.mehmetpekdemir.generic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserResponse findById(Long id) {
        return toResponse(findUserById(id));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserResponse> findPaginated(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponse create(UserCreateRequest userCreateRequest) {
        return toResponse(userRepository.save(toEntity(userCreateRequest)));
    }

    @Override
    @Transactional
    public UserResponse update(UserUpdateRequest userUpdateRequest) {
        final var userEntity = findUserById(userUpdateRequest.getId());
        userEntity.setUsername(userUpdateRequest.getUsername());
        userEntity.setPassword(userUpdateRequest.getPassword());
        return toResponse(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        final var userEntity = findUserById(id);
        userRepository.deleteById(userEntity.getId());
    }

    @Override
    @Transactional
    public boolean existsUserByUsername(String username) {
        return !userRepository.existsUserEntityByUsername(username);
    }

    private UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found Exception"));
    }

    private UserEntity toEntity(UserCreateRequest userCreateRequest) {
        final var userEntity = new UserEntity();
        userEntity.setUsername(userCreateRequest.getUsername());
        userEntity.setPassword(userCreateRequest.getPassword());
        return userEntity;
    }

    private UserResponse toResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .build();
    }

}
