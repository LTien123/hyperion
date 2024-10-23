package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewPermissionRequest;
import com.fanci.Hyperion_be.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> findAllPermission();

    PermissionResponse findPermissionById(Long id);

    PermissionResponse addNewPermission(CreateNewPermissionRequest request);
}
