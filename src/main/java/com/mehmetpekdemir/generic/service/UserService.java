package com.mehmetpekdemir.generic.service;

import com.mehmetpekdemir.generic.dto.request.UserCreateRequest;
import com.mehmetpekdemir.generic.dto.request.UserUpdateRequest;
import com.mehmetpekdemir.generic.dto.response.UserResponse;
import com.mehmetpekdemir.generic.common.generic.GenericService;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserService extends GenericService<UserResponse, UserCreateRequest, UserUpdateRequest> {

    boolean existsUserByUsername(String username);

}
