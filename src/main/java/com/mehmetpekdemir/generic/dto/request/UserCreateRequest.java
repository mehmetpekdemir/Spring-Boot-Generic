package com.mehmetpekdemir.generic.dto.request;

import com.mehmetpekdemir.generic.common.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class UserCreateRequest {

    @Size(min = 4, max = 48)
    @NotBlank
    @UniqueUsername
    private String username;

    @Size(min = 4, max = 32)
    @NotBlank
    private String password;

}
