package com.amperly.Amperly.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amperly.Amperly.entity.User;

public interface userRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
