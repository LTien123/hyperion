package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Optional<Permission> findPermissionByPermissionName(String permissionName);
}
