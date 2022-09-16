package com.chuwa.redbook2.dao.security;

import com.chuwa.redbook2.entity.security.Role;
import com.chuwa.redbook2.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByAccountOrEmail(String account, String email);

    Optional<User> findByAccount(String username);

    Boolean existsByAccount(String user);

    Boolean existsByEmail(String email);


}
