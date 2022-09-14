package com.chuwa.redbook.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuwa.redbook.entity.Role;

import java.util.Optional;

/**
 * @author b1go
 * @date 6/26/22 4:03 PM
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
