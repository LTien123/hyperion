package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewRoleRequest;
import com.fanci.Hyperion_be.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAllRole();

    RoleResponse addNewRole(CreateNewRoleRequest request);

    RoleResponse findRoleById(Long id);
}
