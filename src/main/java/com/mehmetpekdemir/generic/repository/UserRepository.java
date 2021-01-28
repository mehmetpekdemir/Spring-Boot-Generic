package com.mehmetpekdemir.generic.repository;

import com.mehmetpekdemir.generic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsUserEntityByUsername(String username);

}
