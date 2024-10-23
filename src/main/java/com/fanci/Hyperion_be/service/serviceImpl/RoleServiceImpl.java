package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.PermissionDto;
import com.fanci.Hyperion_be.dto.request.CreateNewRoleRequest;
import com.fanci.Hyperion_be.dto.response.RoleResponse;
import com.fanci.Hyperion_be.entity.Permission;
import com.fanci.Hyperion_be.entity.Role;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.PermissionMapper;
import com.fanci.Hyperion_be.mapper.RoleMapper;
import com.fanci.Hyperion_be.repository.PermissionRepository;
import com.fanci.Hyperion_be.repository.RoleRepository;
import com.fanci.Hyperion_be.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

    @Override
    public List<RoleResponse> findAllRole() {
        return roleRepository.findAll().stream().map(this::toRoleResponse).toList();
    }

    @Override
    public RoleResponse addNewRole(CreateNewRoleRequest request) {
        if (roleRepository.findRoleByRoleName(request.getRoleName()).isPresent()) {
            throw new AppException(ErrorCode.ROLE_NAME_DUPLICATED);
        }
        Set<Permission> permissions = request.getPermissionId().stream().map(id -> permissionRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PERMISSION_ID_NOT_FOUND))).collect(Collectors.toSet());
        Role role = Role.builder()
                .roleName(request.getRoleName())
                .permissions(permissions)
                .build();
        return toRoleResponse(roleRepository.save(role));
    }

    @Override
    public RoleResponse findRoleById(Long id) {
        var role = roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_ID_NOT_FOUND));
        return toRoleResponse(role);
    }

    private RoleResponse toRoleResponse(Role role) {
        RoleResponse roleResponse = roleMapper.toRoleResponse(role);
        List<PermissionDto> permissionDtoList = role.getPermissions().stream().map(permissionMapper::toPermissionDto).toList();
        roleResponse.setPermissionDtoList(permissionDtoList);
        return roleResponse;
    }

}
