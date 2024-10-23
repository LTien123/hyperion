package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findRoleByRoleName(String roleName);
}
