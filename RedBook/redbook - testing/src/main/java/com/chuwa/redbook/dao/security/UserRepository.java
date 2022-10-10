package com.chuwa.redbook.dao.security;

import com.chuwa.redbook.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAccountOrEmail (String account, String email);
    Optional<User> findByAccount (String account);

    Boolean existsByAccount(String account);
    Boolean existsByEmail(String email);
}
