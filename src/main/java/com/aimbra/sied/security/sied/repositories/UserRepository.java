package com.aimbra.sied.security.sied.repositories;

import com.aimbra.sied.security.sied.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findFirstByUsernameEquals(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
