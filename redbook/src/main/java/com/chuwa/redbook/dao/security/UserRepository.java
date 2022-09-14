package com.chuwa.redbook.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuwa.redbook.entity.User;

import java.util.Optional;

/**
 * @author b1go
 * @date 6/26/22 3:57 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param email
     * @return Optional
     */
    Optional<User> findByEmail(String email);

    Optional<User> findByAccountOrEmail(String account, String email);

    Optional<User> findByAccount(String username);

    Boolean existsByAccount(String user);

    Boolean existsByEmail(String email);
}
