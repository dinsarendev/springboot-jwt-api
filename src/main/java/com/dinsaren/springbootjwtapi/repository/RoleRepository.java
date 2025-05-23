package com.dinsaren.springbootjwtapi.repository;

import com.dinsaren.springbootjwtapi.models.Role;
import com.dinsaren.springbootjwtapi.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
